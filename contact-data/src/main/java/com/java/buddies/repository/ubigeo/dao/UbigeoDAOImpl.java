package com.java.buddies.repository.ubigeo.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.buddies.commons.PropertiesReader;
import com.java.buddies.repository.ubigeo.wrapper.UbigeoResponseWrapper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class UbigeoDAOImpl implements UbigeoDAO {

  private static final ObjectMapper objectMapper = new ObjectMapper();
  private final PropertiesReader propertiesReader;

  public UbigeoDAOImpl() {
    this.propertiesReader = new PropertiesReader();
  }

  public UbigeoResponseWrapper findUbigeo(String ubigeoCode) {
    Socket socket = null;
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;

    try {
      String host = propertiesReader.getProperty("services.ubigeo.host");
      int port = Integer.parseInt(propertiesReader.getProperty("services.ubigeo.port"));
      socket = new Socket(host, port);

      outputStream = new DataOutputStream(socket.getOutputStream());
      inputStream = new DataInputStream(socket.getInputStream());

      outputStream.writeUTF("ubigeo/" + ubigeoCode);

      String ubigeoJson = inputStream.readUTF();
      return objectMapper.readValue(ubigeoJson, UbigeoResponseWrapper.class);

    } catch (Exception exception) {
      throw new RuntimeException("Error processing ubigeo: " + exception.getMessage());

    } finally {
      try {
        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        if (socket != null) socket.close();

      } catch (Exception exception) {
        throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
      }
    }
  }
}

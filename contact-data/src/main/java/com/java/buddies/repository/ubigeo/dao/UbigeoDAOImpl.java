package com.java.buddies.repository.ubigeo.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.buddies.commons.PropertiesReader;
import com.java.buddies.repository.ubigeo.wrapper.UbigeoResponseWrapper;
import java.io.*;
import java.net.Socket;

public class UbigeoDAOImpl implements UbigeoDAO {

  private static final ObjectMapper objectMapper = new ObjectMapper();
  private final PropertiesReader propertiesReader;

  public UbigeoDAOImpl() {
    this.propertiesReader = new PropertiesReader();
  }

  public UbigeoResponseWrapper findUbigeo(String ubigeoCode) {
    Socket socket = null;
    PrintWriter outputWriter = null;
    BufferedReader inputReader = null;

    try {
      String host = propertiesReader.getProperty("services.ubigeo.host");
      int port = Integer.parseInt(propertiesReader.getProperty("services.ubigeo.port"));
      socket = new Socket(host, port);

      outputWriter = new PrintWriter(socket.getOutputStream(), true);
      inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      outputWriter.println("ubigeo/" + ubigeoCode);

      String ubigeoJson = inputReader.readLine();
      return objectMapper.readValue(ubigeoJson, UbigeoResponseWrapper.class);

    } catch (Exception exception) {
      throw new RuntimeException("Error processing ubigeo: " + exception.getMessage());

    } finally {
      try {
        if (inputReader != null) inputReader.close();
        if (outputWriter != null) outputWriter.close();
        if (socket != null) socket.close();

      } catch (Exception exception) {
        throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
      }
    }
  }
}

package com.demo.poc.dao.ubigeo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.poc.commons.PropertiesReader;
import com.demo.poc.dao.ubigeo.wrapper.UbigeoResponseWrapper;
import com.google.inject.Inject;
import java.io.*;
import java.net.Socket;

public class UbigeoDAOImpl implements UbigeoDAO {

  private final ObjectMapper objectMapper;
  private final PropertiesReader propertiesReader;

  @Inject
  public UbigeoDAOImpl(PropertiesReader propertiesReader, ObjectMapper objectMapper) {
    this.propertiesReader = propertiesReader;
    this.objectMapper = objectMapper;
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

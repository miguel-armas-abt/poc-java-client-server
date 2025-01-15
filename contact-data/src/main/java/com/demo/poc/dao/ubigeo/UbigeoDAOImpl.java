package com.demo.poc.dao.ubigeo;

import static com.demo.poc.commons.TCPResourceHelper.closeResources;

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
      String ip = propertiesReader.getProperty("services.ubigeo.host");
      int port = Integer.parseInt(propertiesReader.getProperty("services.ubigeo.port"));
      socket = new Socket(ip, port);

      //send request
      outputWriter = new PrintWriter(socket.getOutputStream(), true);
      String ubigeoEndpoint = propertiesReader.getProperty("services.ubigeo.endpoint");
      outputWriter.println(ubigeoEndpoint + ubigeoCode);

      //receive response
      inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String ubigeoJson = inputReader.readLine();

      return objectMapper.readValue(ubigeoJson, UbigeoResponseWrapper.class);

    } catch (IOException exception) {
      throw new RuntimeException("Error calling ubigeo service: " + exception.getMessage(), exception);

    } finally {
      closeResources(socket, inputReader, outputWriter);
    }
  }
}

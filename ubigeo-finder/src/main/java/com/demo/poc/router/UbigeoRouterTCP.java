package com.demo.poc.router;

import static com.demo.poc.commons.TCPResourceHelper.closeResource;

import com.demo.poc.dto.UbigeoResponseDTO;
import com.demo.poc.service.UbigeoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import java.io.*;
import java.net.Socket;

public class UbigeoRouterTCP extends Thread {

  private final ObjectMapper objectMapper;
  private final UbigeoService ubigeoService;

  private Socket socket;

  @Inject
  public UbigeoRouterTCP(ObjectMapper objectMapper, UbigeoService ubigeoService) {
    this.objectMapper = objectMapper;
    this.ubigeoService = ubigeoService;
  }

  public void setSocket(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try(
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true)
    ) {
      //receive request
      String endpoint = inputReader.readLine();
      boolean success = false;

      if(endpoint.matches("^ubigeo/\\d{6}$")) {
        String ubigeoCode = endpoint.split("/")[1].trim();
        UbigeoResponseDTO ubigeo = ubigeoService.findUbigeo(ubigeoCode);
        String jsonResponse = objectMapper.writeValueAsString(ubigeo);

        //write response
        outputWriter.println(jsonResponse);
        success = true;
      }

      if(!success)
        throw new IllegalArgumentException("The request '" + endpoint + "' was not processed successfully");

    } catch (IOException exception) {
      throw new RuntimeException("TCP error: " + exception.getMessage(), exception);

    } finally {
      closeResource(socket);
    }
  }

}

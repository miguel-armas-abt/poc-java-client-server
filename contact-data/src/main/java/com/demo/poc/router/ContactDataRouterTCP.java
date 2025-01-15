package com.demo.poc.router;

import static com.demo.poc.commons.TCPResourceHelper.closeResource;

import com.demo.poc.dto.ContactDataDTO;
import com.demo.poc.service.ContactDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import java.io.*;
import java.net.Socket;

public class ContactDataRouterTCP extends Thread {

  private final ObjectMapper objectMapper;
  private final ContactDataService contactDataService;
  private Socket socket;

  @Inject
  public ContactDataRouterTCP(ObjectMapper objectMapper, ContactDataService contactDataService) {
    this.objectMapper = objectMapper;
    this.contactDataService = contactDataService;
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

      if(endpoint.matches("^get/contact-data/\\d{8}$")) {
        String dni = endpoint.split("/")[2].trim();
        ContactDataDTO contactData = contactDataService.findByDni(dni);
        String jsonResponse = objectMapper.writeValueAsString(contactData);

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

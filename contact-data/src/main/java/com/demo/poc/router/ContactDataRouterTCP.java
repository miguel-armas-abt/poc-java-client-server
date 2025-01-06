package com.demo.poc.router;

import com.google.inject.Inject;
import java.io.*;
import java.net.Socket;

public class ContactDataRouterTCP extends Thread {

  private final ContactDataHandler contactDataHandler;
  private Socket socket;

  @Inject
  public ContactDataRouterTCP(ContactDataHandler contactDataHandler) {
    this.contactDataHandler = contactDataHandler;
  }

  public void setSocket(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try(
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true)
    ) {
      String operation = inputReader.readLine();

      if(operation.matches("^contact-data/\\d{8}$")) {
        String ubigeoCode = operation.split("/")[1].trim();
        contactDataHandler.findByDni(ubigeoCode, outputWriter);
      }

    } catch (Exception exception) {
      throw new IllegalArgumentException("Operation not found: " + exception.getMessage());

    } finally {
      try {
        if (socket != null) socket.close();
      } catch (Exception exception) {
        throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
      }
    }
  }

}

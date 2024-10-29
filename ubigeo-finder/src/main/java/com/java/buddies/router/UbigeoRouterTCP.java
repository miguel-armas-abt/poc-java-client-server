package com.java.buddies.router;

import java.io.*;
import java.net.Socket;

public class UbigeoRouterTCP extends Thread {

  private final UbigeoHandler ubigeoHandler;

  private final Socket socket;

  public UbigeoRouterTCP(Socket socket) {
    this.ubigeoHandler = new UbigeoHandler();
    this.socket = socket;
  }

  public void run() {
    try(
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true)
    ) {
      String operation = inputReader.readLine();

      if(operation.matches("^ubigeo/\\d{6}$")) {
        String ubigeoCode = operation.split("/")[1].trim();
        ubigeoHandler.findUbigeo(ubigeoCode, outputWriter);
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

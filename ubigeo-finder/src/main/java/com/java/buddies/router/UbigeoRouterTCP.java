package com.java.buddies.router;

import com.java.buddies.commons.PropertiesReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class UbigeoRouterTCP extends Thread {

  private final UbigeoHandler ubigeoHandler;
  private final PropertiesReader propertiesReader;

  private final Socket socket;
  private DataInputStream inputStream = null;
  private DataOutputStream outputStream = null;

  public UbigeoRouterTCP(Socket socket) {
    this.propertiesReader = new PropertiesReader();
    this.ubigeoHandler = new UbigeoHandler();
    this.socket = socket;
  }

  public void run() {
    try {
      inputStream = new DataInputStream(socket.getInputStream());
      outputStream = new DataOutputStream(socket.getOutputStream());

      String operation = inputStream.readUTF();

      if(operation.matches("^ubigeo/\\d{6}$")) {
        String ubigeoCode = operation.split("/")[1].trim();
        ubigeoHandler.findUbigeo(ubigeoCode, outputStream);
      }

    } catch (Exception exception) {
      throw new IllegalArgumentException("Operation not found: " + exception.getMessage());

    } finally {
      try {
        if (outputStream != null) outputStream.close();
        if (inputStream != null) inputStream.close();
        if (socket != null) socket.close();
      } catch (Exception exception) {
        throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
      }
    }
  }

}

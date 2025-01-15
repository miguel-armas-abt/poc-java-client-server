package com.demo.poc.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TCPResourceHelper {

  public static void closeResources(Socket socket, BufferedReader inputReader, PrintWriter outputWriter) {
    try {
      if (inputReader != null) inputReader.close();
      if (outputWriter != null) outputWriter.close();
      closeResource(socket);

    } catch (IOException exception) {
      throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
    }
  }

  public static void closeResource(Socket socket) {
    try {
      if (socket != null) socket.close();
    } catch (IOException exception) {
      throw new RuntimeException("Error closing TCP connection: " + exception.getMessage(), exception);
    }
  }
}

package com.demo.poc.commons;

import java.io.IOException;
import java.net.Socket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TCPResourceHelper {

  public static void closeResource(Socket socket) {
    try {
      if (socket != null) socket.close();
    } catch (IOException exception) {
      throw new RuntimeException("Error closing TCP connection: " + exception.getMessage(), exception);
    }
  }
}

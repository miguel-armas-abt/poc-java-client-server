package com.java.buddies.router;

import com.java.buddies.commons.PropertiesReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionServer {

  private final PropertiesReader propertiesReader;

  public ConnectionServer() {
    this.propertiesReader = new PropertiesReader();
  }

  public void start() throws IOException {
    int port = Integer.parseInt(propertiesReader.getProperty("tcp.port"));
    ServerSocket serverSocket = new ServerSocket(port);
    Socket currentSocket;
    while (true) {
      currentSocket = serverSocket.accept();
      new UbigeoRouterTCP(currentSocket).start();
      log.info("A new connection was detected");
    }
  }

}

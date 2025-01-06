package com.demo.poc.router;

import com.google.inject.Inject;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionServer {

  private final ContactDataRouterTCP contactDataRouterTCP;
  private final ServerSocket serverSocket;

  @Inject
  public ConnectionServer(ContactDataRouterTCP contactDataRouterTCP,
                          ServerSocket serverSocket) {
    this.contactDataRouterTCP = contactDataRouterTCP;
    this.serverSocket = serverSocket;
  }

  public void start() throws IOException {
    Socket socket;
    while (true) {
      socket = serverSocket.accept();
      contactDataRouterTCP.setSocket(socket);
      contactDataRouterTCP.start();
      log.info("A new connection was detected");
    }
  }

}

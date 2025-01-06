package com.demo.poc.router;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionServer {

  private final Provider<ContactDataRouterTCP> tcpRouterProvider;
  private final ServerSocket serverSocket;

  @Inject
  public ConnectionServer(Provider<ContactDataRouterTCP> tcpRouterProvider,
                          ServerSocket serverSocket) {
    this.tcpRouterProvider = tcpRouterProvider;
    this.serverSocket = serverSocket;
  }

  public void start() throws IOException {
    Socket socket;
    while (true) {
      socket = serverSocket.accept();
      ContactDataRouterTCP router = tcpRouterProvider.get();
      router.setSocket(socket);
      router.start();
      log.info("A new connection was detected");
    }
  }

}

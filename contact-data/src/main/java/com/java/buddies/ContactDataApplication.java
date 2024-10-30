package com.java.buddies;

import com.java.buddies.router.ConnectionServer;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContactDataApplication {

  public static void main(String[] args) throws IOException {
    ConnectionServer server = new ConnectionServer();
    server.start();
  }

}
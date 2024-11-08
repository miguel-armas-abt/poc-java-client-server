package com.demo.poc;

import com.demo.poc.router.ConnectionServer;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContactDataApplication {

  public static void main(String[] args) throws IOException {
    ConnectionServer server = new ConnectionServer();
    server.start();
  }

}
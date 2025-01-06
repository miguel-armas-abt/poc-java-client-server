package com.demo.poc;

import com.demo.poc.commons.ComponentInjectorConfig;
import com.demo.poc.router.ConnectionServer;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContactDataApplication {

  public static void main(String[] args) throws IOException {
    Injector injector = Guice.createInjector(new ComponentInjectorConfig());
    ConnectionServer server = injector.getInstance(ConnectionServer.class);
    server.start();
  }

}

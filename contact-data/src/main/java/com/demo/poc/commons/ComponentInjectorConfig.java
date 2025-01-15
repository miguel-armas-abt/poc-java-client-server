package com.demo.poc.commons;

import static com.demo.poc.commons.Constant.*;

import com.demo.poc.repository.customer.CustomerRepository;
import com.demo.poc.dao.customer.CustomerDAO;
import com.demo.poc.dao.customer.CustomerDAOImpl;
import com.demo.poc.repository.ubigeo.UbigeoRepository;
import com.demo.poc.dao.ubigeo.UbigeoDAO;
import com.demo.poc.dao.ubigeo.UbigeoDAOImpl;
import com.demo.poc.router.ConnectionServer;
import com.demo.poc.router.ContactDataRouterTCP;
import com.demo.poc.service.ContactDataService;
import com.demo.poc.service.ContactDataServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.net.ServerSocket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComponentInjectorConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(PropertiesReader.class);
        bind(CustomerDAO.class).to(CustomerDAOImpl.class);
        bind(UbigeoDAO.class).to(UbigeoDAOImpl.class);
        bind(CustomerRepository.class);
        bind(UbigeoRepository.class);
        bind(ContactDataService.class).to(ContactDataServiceImpl.class);
        bind(ObjectMapper.class);
        bind(ContactDataRouterTCP.class);
        bind(ServerSocket.class).toProvider(ServerSocketProvider.class);
        bind(ConnectionServer.class);
    }

    static class ServerSocketProvider implements Provider<ServerSocket> {
        private final PropertiesReader propertiesReader;

        @Inject
        public ServerSocketProvider(PropertiesReader propertiesReader) {
            this.propertiesReader = propertiesReader;
        }

        @Override
        public ServerSocket get() {
            int port = Integer.parseInt(propertiesReader.getProperty("application.port"));
            try {
                log.info(GREEN + BOLD + "Application started on port " + port + RESET);
                return new ServerSocket(port);
            } catch (IOException exception) {
                throw new RuntimeException("Error creating socket: " + exception.getMessage(), exception);
            }
        }
    }
}

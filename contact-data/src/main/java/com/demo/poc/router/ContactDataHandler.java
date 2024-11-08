package com.demo.poc.router;

import com.demo.poc.service.ContactDataService;
import com.demo.poc.service.ContactDataServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.poc.dto.ContactDataDTO;

import java.io.IOException;
import java.io.PrintWriter;

public class ContactDataHandler {

  private final static ObjectMapper objectMapper = new ObjectMapper();
  private final ContactDataService contactDataService;

  public ContactDataHandler() {
    this.contactDataService = new ContactDataServiceImpl();
  }

  public void findByDni(String dni, PrintWriter output) throws IOException {
    ContactDataDTO contactData = contactDataService.findByDni(dni);
    String contactDataJson = objectMapper.writeValueAsString(contactData);

    output.println(contactDataJson);
  }

}

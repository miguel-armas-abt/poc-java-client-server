package com.demo.poc.router;

import com.demo.poc.service.ContactDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.poc.dto.ContactDataDTO;
import com.google.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;

public class ContactDataHandler {

  private final ObjectMapper objectMapper;
  private final ContactDataService contactDataService;

  @Inject
  public ContactDataHandler(ObjectMapper objectMapper, ContactDataService contactDataService) {
    this.objectMapper = objectMapper;
    this.contactDataService = contactDataService;
  }

  public void findByDni(String dni, PrintWriter output) throws IOException {
    ContactDataDTO contactData = contactDataService.findByDni(dni);
    String contactDataJson = objectMapper.writeValueAsString(contactData);

    output.println(contactDataJson);
  }

}

package com.java.buddies;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.buddies.service.ContactDataService;
import com.java.buddies.service.ContactDataServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

  public static void main(String[] args) throws JsonProcessingException {

    ContactDataService contactDataService = new ContactDataServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();
    log.info(objectMapper.writeValueAsString(contactDataService.findByDni("76517368")));
  }

}
package com.demo.poc.router;

import com.demo.poc.service.UbigeoService;
import com.demo.poc.service.UbigeoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.poc.dto.UbigeoResponseDTO;

import java.io.IOException;
import java.io.PrintWriter;

public class UbigeoHandler {

  private final ObjectMapper objectMapper;
  private final UbigeoService ubigeoService;

  public UbigeoHandler() {
    ubigeoService = new UbigeoServiceImpl();
    objectMapper = new ObjectMapper();
  }

  public void findUbigeo(String ubigeoCode, PrintWriter output) throws IOException {
    UbigeoResponseDTO ubigeo = ubigeoService.findUbigeo(ubigeoCode);
    String ubigeoJson = objectMapper.writeValueAsString(ubigeo);

    output.println(ubigeoJson);
  }

}

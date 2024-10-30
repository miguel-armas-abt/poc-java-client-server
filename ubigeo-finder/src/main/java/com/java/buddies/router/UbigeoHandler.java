package com.java.buddies.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.buddies.dto.UbigeoResponseDTO;
import com.java.buddies.service.UbigeoService;
import com.java.buddies.service.UbigeoServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;

public class UbigeoHandler {

  private final static ObjectMapper objectMapper = new ObjectMapper();
  private final UbigeoService ubigeoService;

  public UbigeoHandler() {
    ubigeoService = new UbigeoServiceImpl();
  }

  public void findUbigeo(String ubigeoCode, PrintWriter output) throws IOException {
    UbigeoResponseDTO ubigeo = ubigeoService.findUbigeo(ubigeoCode);
    String ubigeoJson = objectMapper.writeValueAsString(ubigeo);

    output.println(ubigeoJson);
  }

}

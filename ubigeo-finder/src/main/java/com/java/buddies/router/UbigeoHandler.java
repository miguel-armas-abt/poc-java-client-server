package com.java.buddies.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.buddies.dto.UbigeoResponseDTO;
import com.java.buddies.service.UbigeoService;
import com.java.buddies.service.UbigeoServiceImpl;
import java.io.DataOutputStream;
import java.io.IOException;

public class UbigeoHandler {

  private final static ObjectMapper objectMapper = new ObjectMapper();
  private final UbigeoService ubigeoService;

  public UbigeoHandler() {
    ubigeoService = new UbigeoServiceImpl();
  }

  void findUbigeo(String ubigeoCode, DataOutputStream output) throws IOException {
    UbigeoResponseDTO ubigeo = ubigeoService.findUbigeo(ubigeoCode);
    String ubigeoJson = objectMapper.writeValueAsString(ubigeo);

    output.writeUTF(ubigeoJson);
  }

}
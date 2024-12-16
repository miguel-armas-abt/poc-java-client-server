package com.demo.poc.repository.ubigeo;

import com.demo.poc.dao.ubigeo.UbigeoDAO;
import com.demo.poc.dao.ubigeo.wrapper.UbigeoResponseWrapper;
import com.google.inject.Inject;

public class UbigeoRepository {

  private final UbigeoDAO ubigeoDAO;

  @Inject
  public UbigeoRepository(UbigeoDAO ubigeoDAO) {
    this.ubigeoDAO = ubigeoDAO;
  }

  public UbigeoResponseWrapper findUbigeo(String ubigeoCode) {
    return ubigeoDAO.findUbigeo(ubigeoCode);
  }
}

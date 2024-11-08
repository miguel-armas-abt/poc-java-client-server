package com.demo.poc.repository.ubigeo;

import com.demo.poc.repository.ubigeo.dao.UbigeoDAO;
import com.demo.poc.repository.ubigeo.dao.UbigeoDAOImpl;
import com.demo.poc.repository.ubigeo.wrapper.UbigeoResponseWrapper;

public class UbigeoRepository {

  private final UbigeoDAO ubigeoDAO;

  public UbigeoRepository() {
    this.ubigeoDAO = new UbigeoDAOImpl();
  }

  public UbigeoResponseWrapper findUbigeo(String ubigeoCode) {
    return ubigeoDAO.findUbigeo(ubigeoCode);
  }
}

package com.java.buddies.repository.ubigeo;

import com.java.buddies.repository.ubigeo.dao.UbigeoDAO;
import com.java.buddies.repository.ubigeo.dao.UbigeoDAOImpl;
import com.java.buddies.repository.ubigeo.wrapper.UbigeoResponseWrapper;

public class UbigeoRepository {

  private final UbigeoDAO ubigeoDAO;

  public UbigeoRepository() {
    this.ubigeoDAO = new UbigeoDAOImpl();
  }

  public UbigeoResponseWrapper findUbigeo(String ubigeoCode) {
    return ubigeoDAO.findUbigeo(ubigeoCode);
  }
}

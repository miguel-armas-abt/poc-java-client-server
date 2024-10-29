package com.java.buddies.repository.ubigeo.dao;

import com.java.buddies.repository.ubigeo.wrapper.UbigeoResponseWrapper;

public interface UbigeoDAO {

  UbigeoResponseWrapper findUbigeo(String ubigeoCode);
}

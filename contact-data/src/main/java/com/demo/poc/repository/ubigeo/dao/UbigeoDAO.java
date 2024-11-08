package com.demo.poc.repository.ubigeo.dao;

import com.demo.poc.repository.ubigeo.wrapper.UbigeoResponseWrapper;

public interface UbigeoDAO {

  UbigeoResponseWrapper findUbigeo(String ubigeoCode);
}

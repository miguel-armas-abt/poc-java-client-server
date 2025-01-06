package com.demo.poc.dao.ubigeo;

import com.demo.poc.dao.ubigeo.wrapper.UbigeoResponseWrapper;

public interface UbigeoDAO {

  UbigeoResponseWrapper findUbigeo(String ubigeoCode);
}

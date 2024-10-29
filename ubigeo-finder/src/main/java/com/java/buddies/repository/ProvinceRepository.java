package com.java.buddies.repository;

import com.java.buddies.commons.JsonFileReader;
import com.java.buddies.commons.PropertiesReader;
import com.java.buddies.dto.ProvinceDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProvinceRepository {

  private final PropertiesReader propertiesReader;
  private final JsonFileReader jsonFileReader;

  public ProvinceRepository() {
    propertiesReader = new PropertiesReader();
    jsonFileReader = new JsonFileReader();
  }

  public ProvinceDTO findByProvinceIdAndDepartmentId(String provinceId, String departmentId) {
    List<ProvinceDTO> allProvinces = findAll();

    for (ProvinceDTO province: allProvinces) {
      if(province.getId().equals(provinceId) && province.getDepartmentId().equals(departmentId))
        return province;
    }

    throw new IllegalArgumentException("No such province");
  }

  public List<ProvinceDTO> findAll() {
    String filePath = propertiesReader.getProperty("ubigeo.provinces.path");
    List<ProvinceDTO> provinces = jsonFileReader.readListFromFile(ProvinceDTO.class, filePath);
    provinces.sort(Comparator.comparing(ProvinceDTO::getId));
    return provinces;
  }
}

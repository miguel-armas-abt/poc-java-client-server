package com.demo.poc.repository;

import com.demo.poc.commons.JsonFileReader;
import com.demo.poc.commons.PropertiesReader;
import com.demo.poc.dto.ProvinceDTO;
import com.google.inject.Inject;
import java.util.Comparator;
import java.util.List;

public class ProvinceRepository {

  private final PropertiesReader propertiesReader;
  private final JsonFileReader jsonFileReader;

  @Inject
  public ProvinceRepository(PropertiesReader propertiesReader, JsonFileReader jsonFileReader) {
    this.propertiesReader = propertiesReader;
    this.jsonFileReader = jsonFileReader;
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

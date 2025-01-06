package com.demo.poc.repository;

import com.demo.poc.commons.JsonFileReader;
import com.demo.poc.commons.PropertiesReader;
import com.demo.poc.dto.DistrictDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Comparator;
import java.util.List;

public class DistrictRepository {

  private final PropertiesReader propertiesReader;
  private final JsonFileReader jsonFileReader;

  public DistrictRepository() {
    propertiesReader = new PropertiesReader();
    jsonFileReader = new JsonFileReader();
  }

  public DistrictDTO findByDistrictIdAndProvinceIdAndDepartmentId(String districtId, String provinceId, String departmentId) {
    List<DistrictDTO> allDistricts = findAll();

    for (DistrictDTO district: allDistricts) {
      if(district.getId().equals(districtId) && district.getProvinceId().equals(provinceId) && district.getDepartmentId().equals(departmentId))
        return district;
    }

    throw new IllegalArgumentException("No such district");
  }

  public List<DistrictDTO> findAll() {
    String filePath = propertiesReader.getProperty("ubigeo.districts.path");
    List<DistrictDTO> districts = jsonFileReader.readListFromFile(filePath, new TypeReference<>() {});
    districts.sort(Comparator.comparing(DistrictDTO::getId));
    return districts;
  }

}

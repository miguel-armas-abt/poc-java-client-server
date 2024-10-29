package com.java.buddies.repository;

import com.java.buddies.commons.JsonFileReader;
import com.java.buddies.commons.PropertiesReader;
import com.java.buddies.dto.DistrictDTO;
import java.util.ArrayList;
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
    List<DistrictDTO> districts = jsonFileReader.readListFromFile(DistrictDTO.class, filePath);
    districts.sort(Comparator.comparing(DistrictDTO::getId));
    return districts;
  }

}

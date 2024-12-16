package com.demo.poc.repository;

import com.demo.poc.dto.DepartmentDTO;
import com.demo.poc.commons.JsonFileReader;
import com.demo.poc.commons.PropertiesReader;
import com.google.inject.Inject;
import java.util.Comparator;
import java.util.List;

public class DepartmentRepository {

  private final PropertiesReader propertiesReader;
  private final JsonFileReader jsonFileReader;

  @Inject
  public DepartmentRepository(PropertiesReader propertiesReader, JsonFileReader jsonFileReader) {
    this.propertiesReader = propertiesReader;
    this.jsonFileReader = jsonFileReader;
  }

  public DepartmentDTO findByDepartmentId(String departmentId) {
    List<DepartmentDTO> departments = findAll();
    for (DepartmentDTO department: departments) {
      if(department.getId().equals(departmentId))
        return department;
    }
    throw new IllegalArgumentException("No such department");
  }

  public List<DepartmentDTO> findAll() {
    String filePath = propertiesReader.getProperty("ubigeo.departments.path");
    List<DepartmentDTO> departments = jsonFileReader.readListFromFile(DepartmentDTO.class, filePath);
    departments.sort(Comparator.comparing(DepartmentDTO::getId));
    return departments;
  }
}

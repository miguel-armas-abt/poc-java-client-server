package com.java.buddies.service;

import com.java.buddies.dto.DepartmentDTO;
import com.java.buddies.dto.DistrictDTO;
import com.java.buddies.dto.ProvinceDTO;
import com.java.buddies.dto.UbigeoResponseDTO;
import com.java.buddies.repository.DepartmentRepository;
import com.java.buddies.repository.DistrictRepository;
import com.java.buddies.repository.ProvinceRepository;

public class UbigeoServiceImpl implements UbigeoService {

  private final DepartmentRepository departmentRepository;
  private final ProvinceRepository provinceRepository;
  private final DistrictRepository districtRepository;

  public UbigeoServiceImpl() {
    this.departmentRepository = new DepartmentRepository();
    this.provinceRepository = new ProvinceRepository();
    this.districtRepository = new DistrictRepository();
  }

  @Override
  public UbigeoResponseDTO findUbigeo(String ubigeoCode) {
    String departmentId = ubigeoCode.substring(0, 2);
    String provinceId = ubigeoCode.substring(2, 4);
    String districtId = ubigeoCode.substring(4, 6);

    DepartmentDTO department = departmentRepository.findByDepartmentId(departmentId);
    ProvinceDTO province = provinceRepository.findByProvinceIdAndDepartmentId(provinceId, departmentId);
    DistrictDTO district = districtRepository.findByDistrictIdAndProvinceIdAndDepartmentId(districtId, provinceId, departmentId);

    return UbigeoResponseDTO.builder()
        .code(ubigeoCode)
        .department(department)
        .province(province)
        .district(district)
        .build();
  }
}
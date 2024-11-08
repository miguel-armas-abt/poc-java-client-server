package com.demo.poc.service;

import com.demo.poc.dto.DepartmentDTO;
import com.demo.poc.repository.ProvinceRepository;
import com.demo.poc.dto.DistrictDTO;
import com.demo.poc.dto.ProvinceDTO;
import com.demo.poc.dto.UbigeoResponseDTO;
import com.demo.poc.repository.DepartmentRepository;
import com.demo.poc.repository.DistrictRepository;

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
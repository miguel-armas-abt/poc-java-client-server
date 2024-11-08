package com.demo.poc.mapper;

import com.demo.poc.dto.AddressDTO;
import com.demo.poc.dto.ContactDataDTO;
import com.demo.poc.repository.customer.entity.CustomerEntity;
import com.demo.poc.repository.ubigeo.wrapper.UbigeoResponseWrapper;

public class ContactDataMapper {

  public ContactDataDTO toDTO(CustomerEntity customer, UbigeoResponseWrapper ubigeo) {
    return ContactDataDTO.builder()
        .name(customer.getName())
        .dni(customer.getDni())
        .address(AddressDTO.builder()
            .department(ubigeo.getDepartment().getDescription())
            .province(ubigeo.getProvince().getDescription())
            .district(ubigeo.getDistrict().getDescription())
            .build())
        .build();
  }

}

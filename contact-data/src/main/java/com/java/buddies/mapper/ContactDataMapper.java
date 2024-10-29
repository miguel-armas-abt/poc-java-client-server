package com.java.buddies.mapper;

import com.java.buddies.dto.AddressDTO;
import com.java.buddies.dto.ContactDataDTO;
import com.java.buddies.repository.customer.entity.CustomerEntity;
import com.java.buddies.repository.ubigeo.wrapper.UbigeoResponseWrapper;

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

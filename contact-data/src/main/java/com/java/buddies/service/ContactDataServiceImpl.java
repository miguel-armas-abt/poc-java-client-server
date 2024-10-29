package com.java.buddies.service;

import com.java.buddies.dto.ContactDataDTO;
import com.java.buddies.repository.customer.entity.CustomerEntity;
import com.java.buddies.mapper.ContactDataMapper;
import com.java.buddies.repository.customer.CustomerRepository;
import com.java.buddies.repository.ubigeo.UbigeoRepository;
import com.java.buddies.repository.ubigeo.wrapper.UbigeoResponseWrapper;

public class ContactDataServiceImpl implements ContactDataService {

  private final ContactDataMapper mapper;
  private final CustomerRepository customerRepository;
  private final UbigeoRepository ubigeoRepository;

  public ContactDataServiceImpl() {
    mapper = new ContactDataMapper();
    customerRepository = new CustomerRepository();
    ubigeoRepository = new UbigeoRepository();
  }

  @Override
  public ContactDataDTO findByDni(String dni) {
    CustomerEntity customer = customerRepository.findByDni(dni);
    UbigeoResponseWrapper ubigeo = ubigeoRepository.findUbigeo(customer.getUbigeoCode());
    return mapper.toDTO(customer, ubigeo);
  }
}

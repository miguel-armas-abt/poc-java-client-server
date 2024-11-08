package com.demo.poc.service;

import com.demo.poc.repository.ubigeo.UbigeoRepository;
import com.demo.poc.dto.ContactDataDTO;
import com.demo.poc.repository.customer.entity.CustomerEntity;
import com.demo.poc.mapper.ContactDataMapper;
import com.demo.poc.repository.customer.CustomerRepository;
import com.demo.poc.repository.ubigeo.wrapper.UbigeoResponseWrapper;

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

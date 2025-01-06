package com.demo.poc.dao.customer;

import java.util.List;

import com.demo.poc.dao.customer.entity.CustomerEntity;

public interface CustomerDAO {

  List<CustomerEntity> findAll();

  CustomerEntity findByDni(String dni);
}

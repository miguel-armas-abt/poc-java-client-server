package com.demo.poc.repository.customer.dao;

import java.util.List;

import com.demo.poc.repository.customer.entity.CustomerEntity;

public interface CustomerDAO {

  List<CustomerEntity> findAll();

  CustomerEntity findByDni(String dni);
}

package com.demo.poc.repository.customer;

import com.demo.poc.dao.customer.entity.CustomerEntity;
import com.demo.poc.dao.customer.CustomerDAO;
import com.google.inject.Inject;
import java.util.List;

public class CustomerRepository {

  private final CustomerDAO customerDAO;

  @Inject
  public CustomerRepository(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

  public List<CustomerEntity> findAll() {
    return customerDAO.findAll();
  }

  public CustomerEntity findByDni(String dni) {
    return customerDAO.findByDni(dni);
  }

}

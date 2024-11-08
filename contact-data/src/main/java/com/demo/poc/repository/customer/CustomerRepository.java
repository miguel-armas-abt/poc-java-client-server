package com.demo.poc.repository.customer;

import com.demo.poc.repository.customer.dao.CustomerDAOImpl;
import com.demo.poc.repository.customer.entity.CustomerEntity;
import com.demo.poc.repository.customer.dao.CustomerDAO;

import java.util.List;

public class CustomerRepository {

  private final CustomerDAO customerDAO;

  public CustomerRepository() {
    this.customerDAO = new CustomerDAOImpl();
  }

  public List<CustomerEntity> findAll() {
    return customerDAO.findAll();
  }

  public CustomerEntity findByDni(String dni) {
    return customerDAO.findByDni(dni);
  }

}

package com.java.buddies.repository.customer;

import com.java.buddies.repository.customer.dao.CustomerDAO;
import com.java.buddies.repository.customer.dao.CustomerDAOImpl;
import com.java.buddies.repository.customer.entity.CustomerEntity;
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

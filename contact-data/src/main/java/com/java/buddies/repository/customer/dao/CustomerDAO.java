package com.java.buddies.repository.customer.dao;

import java.util.List;
import com.java.buddies.repository.customer.entity.CustomerEntity;

public interface CustomerDAO {

  List<CustomerEntity> findAll();

  CustomerEntity findByDni(String dni);
}

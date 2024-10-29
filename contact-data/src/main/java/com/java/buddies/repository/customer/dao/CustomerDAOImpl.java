package com.java.buddies.repository.customer.dao;

import com.java.buddies.commons.CsvReader;
import com.java.buddies.repository.customer.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

  private final String FILE = "/database/customers.csv";
  private static final char SEPARATOR = ',';

  @Override
  public List<CustomerEntity> findAll() {
    List<CustomerEntity> customers = new ArrayList<>();
    try {
      CsvReader.getRecords(FILE, SEPARATOR)
          .forEach(csvRecord -> {

            CustomerEntity customer = CustomerEntity.builder()
                .dni(csvRecord.get("DNI"))
                .name(csvRecord.get("NAME"))
                .email(csvRecord.get("EMAIL"))
                .ubigeoCode(csvRecord.get("UBIGEO_CODE"))
                .build();

            customers.add(customer);
          });
    } catch (Exception exception) {
      throw new IllegalArgumentException("Error reading CSV", exception);
    }
    return customers;
  }

  @Override
  public CustomerEntity findByDni(String dni) {
    List<CustomerEntity> allCustomers = this.findAll();
    for (CustomerEntity customer: allCustomers) {
      if(customer.getDni().equals(dni)) {
        return customer;
      }
    }
    throw new IllegalArgumentException("No such customer");
  }
}

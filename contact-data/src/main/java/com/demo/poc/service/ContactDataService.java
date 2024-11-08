package com.demo.poc.service;

import com.demo.poc.dto.ContactDataDTO;

public interface ContactDataService {

  ContactDataDTO findByDni(String dni);
}

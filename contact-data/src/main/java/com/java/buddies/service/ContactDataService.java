package com.java.buddies.service;

import com.java.buddies.dto.ContactDataDTO;

public interface ContactDataService {

  ContactDataDTO findByDni(String dni);
}

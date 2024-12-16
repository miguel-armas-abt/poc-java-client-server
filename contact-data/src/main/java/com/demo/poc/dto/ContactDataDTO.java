package com.demo.poc.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ContactDataDTO implements Serializable {

  private String dni;
  private String name;
  private AddressDTO address;
}

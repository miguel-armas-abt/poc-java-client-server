package com.demo.poc.dao.customer.entity;

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
public class CustomerEntity  implements Serializable{

  private String dni;
  private String name;
  private String email;
  private String ubigeoCode;
}

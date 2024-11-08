package com.demo.poc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UbigeoResponseDTO implements Serializable {

  private String code;
  private DepartmentDTO department;
  private ProvinceDTO province;
  private DistrictDTO district;
}

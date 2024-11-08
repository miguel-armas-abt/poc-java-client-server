package com.demo.poc.repository.ubigeo.wrapper;

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
public class UbigeoResponseWrapper implements Serializable {

  private String code;
  private DepartmentWrapper department;
  private ProvinceWrapper province;
  private DistrictWrapper district;
}

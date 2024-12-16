package com.demo.poc.dao.ubigeo.wrapper;

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
public class UbigeoResponseWrapper implements Serializable {

  private String code;
  private DepartmentWrapper department;
  private ProvinceWrapper province;
  private DistrictWrapper district;
}

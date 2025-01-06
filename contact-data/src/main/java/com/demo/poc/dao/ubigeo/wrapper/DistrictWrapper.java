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
public class DistrictWrapper implements Serializable {

  private String id;
  private String description;
  private String provinceId;
  private String departmentId;
}

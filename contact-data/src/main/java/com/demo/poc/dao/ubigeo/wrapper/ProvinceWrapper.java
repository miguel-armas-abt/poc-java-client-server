package com.demo.poc.dao.ubigeo.wrapper;

import java.io.Serializable;
import java.util.List;
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
public class ProvinceWrapper implements Serializable {

  private String id;
  private String description;
  private String departmentId;
  private List<DistrictWrapper> districts;
}

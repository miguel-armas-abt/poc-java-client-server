package com.demo.poc.dao.ubigeo.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class DepartmentWrapper implements Serializable {

  private String id;
  private String description;
  private List<ProvinceWrapper> provinces;
}

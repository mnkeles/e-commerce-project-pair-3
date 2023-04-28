package com.etiya.ecommercepair3.business.dtos.responses.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDetailResponse {
    private Integer id;
    private String districtName;
    private Integer cityId;
}

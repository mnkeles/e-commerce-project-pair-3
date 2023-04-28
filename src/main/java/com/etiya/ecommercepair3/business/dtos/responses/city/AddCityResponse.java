package com.etiya.ecommercepair3.business.dtos.responses.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityResponse {
    private Integer id;
    private String cityName;
    private Integer countryId;
}

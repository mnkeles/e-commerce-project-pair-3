package com.etiya.ecommercepair3.business.dtos.responses.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCountryResponse {
    private Integer id;
    private String countryName;
}

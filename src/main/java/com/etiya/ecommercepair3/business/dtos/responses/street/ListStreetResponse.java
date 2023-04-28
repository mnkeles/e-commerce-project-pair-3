package com.etiya.ecommercepair3.business.dtos.responses.street;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListStreetResponse {
    private Integer id;
    private String streetName;
    private Integer districtId;
}

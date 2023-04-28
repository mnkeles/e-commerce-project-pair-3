package com.etiya.ecommercepair3.business.dtos.resquests.street;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStreetRequest {
    @NotNull(message = "Minimum 4 ,maksimum 20 karakter olmalıdır.")
    @Size(max = 20,min=4)
    private String streetName;
    private Integer districtId;
}

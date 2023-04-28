package com.etiya.ecommercepair3.business.dtos.resquests.country;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCountryRequest {
    @NotBlank(message = "Minimum 4 ,maksimum 20 karakter olmalıdır.")  // " "  bunu kabul eder
    @NotNull
    @Size(max = 20,min=3)
    private String countryName;
}

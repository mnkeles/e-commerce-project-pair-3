package com.etiya.ecommercepair3.business.dtos.resquests.saleman;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSalesmanRequest {
    @NotNull(message = "Boş bırakılamaz")
    @NotBlank(message = "Boş bırakılamaz")
    @Size(max = 20,min = 4)
    private String name;

}

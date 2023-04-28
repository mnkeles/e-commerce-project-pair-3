package com.etiya.ecommercepair3.business.dtos.resquests.address;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {
    @NotNull(message = "Addres açıklaması boş olamaz")
    @Size(max = 100)
    private String description;
    private Integer streetId;
    private Integer customerId;
}

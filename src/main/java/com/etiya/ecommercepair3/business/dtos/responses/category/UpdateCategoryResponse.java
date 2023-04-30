package com.etiya.ecommercepair3.business.dtos.responses.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryResponse {
    private Integer id;
    private String name;
}

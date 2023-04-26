package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.ProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-attribute")
@RequiredArgsConstructor
public class ProductAttributeController {
    private ProductAttributeService productAttributeService;
}

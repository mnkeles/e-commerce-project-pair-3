package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomersController {
    private CustomerService customerService;
}

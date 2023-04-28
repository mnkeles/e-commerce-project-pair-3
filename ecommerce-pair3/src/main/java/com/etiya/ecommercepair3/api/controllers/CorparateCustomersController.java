package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CorparateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/corarate-customer")
@RequiredArgsConstructor
public class CorparateCustomersController {
    private CorparateCustomerService corparateCustomerService;
}

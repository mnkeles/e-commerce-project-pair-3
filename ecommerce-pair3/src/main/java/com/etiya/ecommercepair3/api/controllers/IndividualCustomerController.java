package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/individual-customer")
@RequiredArgsConstructor
public class IndividualCustomerController {
    private IndividualCustomerService individualCustomerService;
}

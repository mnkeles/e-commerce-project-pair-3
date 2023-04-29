package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.DiscountService;
import com.etiya.ecommercepair3.business.dtos.responses.discount.AddDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailsResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.ListDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.AddDiscountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount")
@RequiredArgsConstructor
public class DiscountsController {

    private final DiscountService discountService;

    @GetMapping()
    public List<ListDiscountResponse> getAll(){
        return discountService.getAll();
    }

    @GetMapping("{id}")
    public DiscountDetailsResponse getById(@PathVariable Integer id){
        return discountService.getById(id);
    }

    @PostMapping("/add")
    public AddDiscountResponse addDiscount(AddDiscountRequest addDiscountRequest){
        return discountService.addDiscount(addDiscountRequest);
    }
}

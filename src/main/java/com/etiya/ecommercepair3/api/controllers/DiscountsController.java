package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.DiscountService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.AddDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.ListDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.UpdateDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.AddDiscountRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.UpdateDiscountRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount")
@RequiredArgsConstructor
public class DiscountsController {

    private final DiscountService discountService;

    @GetMapping()
    public DataResult<List<ListDiscountResponse>> getAll() {
        return discountService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<DiscountDetailResponse> getById(@PathVariable Integer id) {
        return discountService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddDiscountResponse> addDiscount(AddDiscountRequest addDiscountRequest) {
        return discountService.addDiscount(addDiscountRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateDiscountResponse> updateDiscount(@RequestBody @Valid UpdateDiscountRequest updateDiscountRequest) {
        return discountService.updateDiscount(updateDiscountRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteDiscount(@PathVariable Integer id) {
        return discountService.deleteDiscount(id);
    }

}

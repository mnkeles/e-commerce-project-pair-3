package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.RefundService;

import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.AddRefundResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.ListRefundResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.RefundDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.UpdateRefundResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.refund.AddRefundRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.refund.UpdateRefundRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refund")
@RequiredArgsConstructor
public class RefundsController {
    private final RefundService refundService;

    @GetMapping()
    public DataResult<List<ListRefundResponse>> getAll(){
        return refundService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<RefundDetailResponse> getById(@PathVariable Integer id){
        return refundService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddRefundResponse> addRefund(AddRefundRequest addRefundRequest){
        return refundService.addRefund(addRefundRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateRefundResponse> updateRefund(@RequestBody@Valid UpdateRefundRequest updateRefundRequest){
        return refundService.updateRefund(updateRefundRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteRefund(@PathVariable Integer id){
        return refundService.deleteRefund(id);
    }
}

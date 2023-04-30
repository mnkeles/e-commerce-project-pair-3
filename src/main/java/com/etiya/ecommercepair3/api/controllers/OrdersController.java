package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.OrderService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.order.AddOrderRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.order.UpdateOrderRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService orderService;

    @GetMapping()
    public DataResult<List<ListOrderResponse>> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<OrderDetailResponse> getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    public DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest){
        return orderService.addOrder(addOrderRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateOrderResponse> updateOrder(@RequestBody@Valid UpdateOrderRequest updateOrderRequest ){
        return orderService.updateOrder(updateOrderRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteOrder(@PathVariable Integer id){
        return orderService.deleteOrder(id);
    }
}

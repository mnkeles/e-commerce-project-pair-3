package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.order.AddOrderRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.order.UpdateOrderRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface OrderService {

    DataResult<List<ListOrderResponse>> getAll();

    DataResult<OrderDetailResponse> getOrderById(Integer id);

    DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest);

    DataResult<UpdateOrderResponse> updateOrder(UpdateOrderRequest updateOrderRequest);

    Result deleteOrder(Integer id);
}

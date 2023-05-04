package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.InvoiceService;
import com.etiya.ecommercepair3.business.abstracts.OrderService;
import com.etiya.ecommercepair3.business.constants.Messages;
import com.etiya.ecommercepair3.business.dtos.responses.order.AddOrderResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.ListOrderResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.order.UpdateOrderResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.order.AddOrderRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.order.UpdateOrderRequest;
import com.etiya.ecommercepair3.core.internationalization.MessageService;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Order;
import com.etiya.ecommercepair3.repositories.abstracts.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManager implements OrderService {
    private final OrderDao orderDao;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;

    @Override
    public DataResult<Slice<ListOrderResponse>> getAll(Pageable pageable) {
        return new SuccessDataResult<>(orderDao.getAll(pageable), Messages.Order.OrderGetAll);
    }

    @Override
    public DataResult<OrderDetailResponse> getOrderById(Integer id) {
        return new SuccessDataResult<>(orderDao.getByOrderId(id),Messages.Order.OrderGetById);
    }

    @Override
    public DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest) {

        Order order = modelMapperService.forRequest().map(addOrderRequest, Order.class);
        orderDao.save(order);
        AddOrderResponse addOrderResponse = modelMapperService.forResponse().map(order, AddOrderResponse.class);
        return new SuccessDataResult<>(addOrderResponse,Messages.Order.OrderAdded);
    }

    @Override
    public DataResult<UpdateOrderResponse> updateOrder(UpdateOrderRequest updateOrderRequest) {
        // iş kuralı
        Order order = modelMapperService.forRequest().map(updateOrderRequest, Order.class);
        order.setId(updateOrderRequest.getId());
        orderDao.save(order);
        UpdateOrderResponse updateOrderResponse = modelMapperService.forResponse().map(order, UpdateOrderResponse.class);
        return new SuccessDataResult<>(updateOrderResponse,Messages.Order.OrderUpdated);
    }

    @Override
    public Result deleteOrder(Integer id) {
        orderDao.deleteById(id);
        return new SuccessResult(Messages.Order.OrderDeleted);
    }
}

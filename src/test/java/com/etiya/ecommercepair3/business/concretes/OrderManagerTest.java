package com.etiya.ecommercepair3.business.concretes;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import com.etiya.ecommercepair3.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercepair3.core.internationalization.MessageManager;
import com.etiya.ecommercepair3.core.internationalization.MessageService;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperManager;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.entities.concretes.*;
import com.etiya.ecommercepair3.repositories.abstracts.OrderDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.support.ResourceBundleMessageSource;


import java.util.Optional;

public class OrderManagerTest {


    private OrderDao orderDao;

    private ModelMapperService modelMapperService;
    private MessageService messageService;
    private OrderManager orderManager;

    @BeforeEach
    void setUp() {
        modelMapperService = new ModelMapperManager(new ModelMapper());
        messageService  =  new MessageManager(getBundleMessageSource());
        orderDao = mock(OrderDao.class);
        orderManager = new OrderManager(orderDao,modelMapperService,messageService);
    }

    public ResourceBundleMessageSource getBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }




    @Test
    void getById(){
        when(orderDao.getByOrderId(1)).thenReturn(new OrderDetailResponse(1,null,null,null,null,null));
        DataResult<OrderDetailResponse> actualresult = new SuccessDataResult<>(
                new OrderDetailResponse(1, null,null,null,null,null));
        DataResult<OrderDetailResponse> expectedResult = orderManager.getOrderById(1);
        assert actualresult.getData().equals(expectedResult.getData());
    }
}

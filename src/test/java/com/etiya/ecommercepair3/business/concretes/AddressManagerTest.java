package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.dtos.responses.order.OrderDetailResponse;
import com.etiya.ecommercepair3.core.internationalization.MessageManager;
import com.etiya.ecommercepair3.core.internationalization.MessageService;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperManager;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.repositories.abstracts.AddressDao;
import com.etiya.ecommercepair3.repositories.abstracts.OrderDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.support.ResourceBundleMessageSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressManagerTest {

     AddressDao addressDao;

     ModelMapperService modelMapperService;
     MessageService messageService;
     AddressManager addressManager;

    @BeforeEach
    void setUp() {
        modelMapperService = new ModelMapperManager(new ModelMapper());
        messageService  =  new MessageManager(getBundleMessageSource());
        addressDao = mock(AddressDao.class);
        addressManager = new AddressManager(addressDao,modelMapperService,messageService);
    }

    public ResourceBundleMessageSource getBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Test  // Hatalı
    void delete(){
        when(addressDao.deleteById(1)).thenReturn();

        DataResult<OrderDetailResponse> expectedResult = orderManager.getOrderById(1);
        assert actualresult.getData().equals(expectedResult.getData());
    }
}

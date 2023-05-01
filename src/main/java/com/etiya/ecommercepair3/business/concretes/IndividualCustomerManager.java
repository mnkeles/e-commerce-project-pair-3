package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CustomerService;
import com.etiya.ecommercepair3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.IndividualCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.ListIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.UpdateIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Customer;
import com.etiya.ecommercepair3.entities.concretes.IndividualCustomer;
import com.etiya.ecommercepair3.repositories.abstracts.IndividualCustomerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerDao individualCustomerDao;
    private final CustomerService customerService;
    private final ModelMapperService modelMapperService;
    private final MessageSource messageSource;

    @Override
    public DataResult<ListIndividualCustomerResponse> getAll(){
        return new SuccessDataResult<>(individualCustomerDao.getAll());
    }

    @Override
    public DataResult<IndividualCustomerDetailResponse> getById(Integer id){
        return new SuccessDataResult<>(individualCustomerDao.getByIndividualCustomerId(id));
    }

    @Override
    public DataResult<AddIndividualCustomerResponse> addIndividualCustomer(AddIndividualCustomerRequest addIndividualCustomerRequest){
        // iş kuralı
        Customer customer=modelMapperService.forRequest().map(addIndividualCustomerRequest,Customer.class);
        //customerService.addCustomer(customer);
        IndividualCustomer individualCustomer=modelMapperService.forRequest().map(addIndividualCustomerRequest,IndividualCustomer.class);
        individualCustomer.setId(customer.getId());
        individualCustomerDao.save(individualCustomer);
        AddIndividualCustomerResponse addIndividualCustomerResponse=modelMapperService.forResponse().map(individualCustomer,AddIndividualCustomerResponse.class);
        return new SuccessDataResult<>(addIndividualCustomerResponse);

    }

    @Override
    public DataResult<UpdateIndividualCustomerResponse> updateIndividualCustomer(UpdateIndividualCustomerRequest updateIndividualCustomerRequest){
        // iş kuralı
        Customer customer=modelMapperService.forRequest().map(updateIndividualCustomerRequest,Customer.class);
        customer.setId(updateIndividualCustomerRequest.getId());
        customerService.updateCustomer(customer);

        IndividualCustomer individualCustomer=modelMapperService.forRequest().map(updateIndividualCustomerRequest,IndividualCustomer.class);
        individualCustomer.setId(customer.getId());
        individualCustomerDao.save(individualCustomer);

        UpdateIndividualCustomerResponse updateIndividualCustomerResponse=modelMapperService.forResponse().map(individualCustomer,UpdateIndividualCustomerResponse.class);
        return new SuccessDataResult<>(updateIndividualCustomerResponse);

    }

    @Override
    public Result deleteIndividualCustomer(Integer id){
        individualCustomerDao.deleteById(id);
        customerService.deleteCustomer(id);


        return new SuccessResult("X");
    }
}

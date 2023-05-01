package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CorporateCustomerService;
import com.etiya.ecommercepair3.business.abstracts.CustomerService;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.AddCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.CorporateCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.ListCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.UpdateCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer.AddCorporateCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer.UpdateCorporateCustomerRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.CorporateCustomer;
import com.etiya.ecommercepair3.entities.concretes.Customer;
import com.etiya.ecommercepair3.repositories.abstracts.CorporateCustomerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerDao corporateCustomerDao;
    private final ModelMapperService modelMapperService;
    private final MessageSource messageSource;
    private final CustomerService customerService;

    @Override
    public DataResult<ListCorporateCustomerResponse> getAll(){
        return new SuccessDataResult<>(corporateCustomerDao.getAll());
    }

    @Override
    public DataResult<CorporateCustomerDetailResponse> getById(Integer id){
        return new SuccessDataResult<>(corporateCustomerDao.getByCorporateCustomerId(id));
    }

    @Override
    public DataResult<AddCorporateCustomerResponse> addCorporateCustomer(AddCorporateCustomerRequest addCorporateCustomerRequest){
        // iş kuralı
        Customer customer=modelMapperService.forRequest().map(addCorporateCustomerRequest,Customer.class);
        //customerService.addCustomer(customer);
        CorporateCustomer corparateCustomer=modelMapperService.forRequest().map(addCorporateCustomerRequest, CorporateCustomer.class);
        corparateCustomer.setId(customer.getId());
        corporateCustomerDao.save(corparateCustomer);
        AddCorporateCustomerResponse addCorporateCustomerResponse=modelMapperService.forResponse().map(corparateCustomer,AddCorporateCustomerResponse.class);
        return new SuccessDataResult<>(addCorporateCustomerResponse);

    }

    @Override
    public DataResult<UpdateCorporateCustomerResponse> updateCorporateCustomer(UpdateCorporateCustomerRequest updateCorporateCustomerRequest){
        // iş kuralı
        Customer customer=modelMapperService.forRequest().map(updateCorporateCustomerRequest,Customer.class);
        customer.setId(updateCorporateCustomerRequest.getId());
        customerService.updateCustomer(customer);

        CorporateCustomer corparateCustomer=modelMapperService.forRequest().map(updateCorporateCustomerRequest, CorporateCustomer.class);
        corparateCustomer.setId(customer.getId());
        corporateCustomerDao.save(corparateCustomer);

        UpdateCorporateCustomerResponse updateCorporateCustomerResponse=modelMapperService.forResponse().map(corparateCustomer,UpdateCorporateCustomerResponse.class);
        return new SuccessDataResult<>(updateCorporateCustomerResponse);

    }

    @Override
    public Result deleteCorporateCustomer(Integer id){
        corporateCustomerDao.deleteById(id);
        customerService.deleteCustomer(id);


        return new SuccessResult("X");
    }



}

package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.IndividualCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.ListIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.UpdateIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IndividualCustomerService {
    DataResult<Slice<ListIndividualCustomerResponse>> getAll(Pageable pageable);

    DataResult<IndividualCustomerDetailResponse> getById(Integer id);

    DataResult<AddIndividualCustomerResponse> addIndividualCustomer(AddIndividualCustomerRequest addIndividualCustomerRequest);

    DataResult<UpdateIndividualCustomerResponse> updateIndividualCustomer(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    Result deleteIndividualCustomer(Integer id);
}

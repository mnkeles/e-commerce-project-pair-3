package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.AddCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.CorporateCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.ListCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.UpdateCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer.AddCorporateCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer.UpdateCorporateCustomerRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

public interface CorporateCustomerService {
    DataResult<ListCorporateCustomerResponse> getAll();

    DataResult<CorporateCustomerDetailResponse> getById(Integer id);

    DataResult<AddCorporateCustomerResponse> addCorporateCustomer(AddCorporateCustomerRequest addCorporateCustomerRequest);

    DataResult<UpdateCorporateCustomerResponse> updateCorporateCustomer(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);

    Result deleteCorporateCustomer(Integer id);
}

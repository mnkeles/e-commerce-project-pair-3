package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.AddCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.CorporateCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.ListCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.UpdateCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer.AddCorporateCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer.UpdateCorporateCustomerRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface CorporateCustomerService {
    DataResult<Slice<ListCorporateCustomerResponse>> getAll(Pageable pageable);

    DataResult<CorporateCustomerDetailResponse> getById(Integer id);

    DataResult<AddCorporateCustomerResponse> addCorporateCustomer(AddCorporateCustomerRequest addCorporateCustomerRequest);

    DataResult<UpdateCorporateCustomerResponse> updateCorporateCustomer(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);

    Result deleteCorporateCustomer(Integer id);
}

package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.salesman.AddSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.UpdateSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.AddSalesmanRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.UpdateSalesmanRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface SalesmanService {
    DataResult<Slice<ListSalesmanResponse>> getAll(Pageable pageable);

    DataResult<SalesmanDetailResponse> getById(Integer id);

    DataResult<AddSalesmanResponse> addSalesman(AddSalesmanRequest addSalesmanRequest);

    DataResult<UpdateSalesmanResponse> updateSalesman(UpdateSalesmanRequest updateSalesmanRequest);

    Result deleteSalesman(Integer id);
}

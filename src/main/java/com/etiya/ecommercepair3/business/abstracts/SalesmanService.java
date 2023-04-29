package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.salesman.AddSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.AddSalesmanRequest;

import java.util.List;

public interface SalesmanService {
    List<ListSalesmanResponse> getAll();

    SalesmanDetailResponse getById(Integer id);

    AddSalesmanResponse addSalesman(AddSalesmanRequest addSalesmanRequest);
}

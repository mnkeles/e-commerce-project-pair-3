package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.SalesmanService;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.AddSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.AddSalesmanRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concrete.Salesman;
import com.etiya.ecommercepair3.repositories.abstracts.SalesmanDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesmanManager implements SalesmanService {
    private final SalesmanDao salesmanDao;
    private final ModelMapperService modelMapperService;
    @Override
    public List<ListSalesmanResponse> getAll() {
        return salesmanDao.getAll();
    }

    @Override
    public SalesmanDetailResponse getById(Integer id) {
        return salesmanDao.getBySalesmanId(id);
    }

    @Override
    public AddSalesmanResponse addSalesman(AddSalesmanRequest addSalesmanRequest) {
        // iş kuralı

        Salesman salesman=modelMapperService.forRequest().map(addSalesmanRequest,Salesman.class);
        salesmanDao.save(salesman);
        AddSalesmanResponse addSalesmanResponse=modelMapperService.forResponse().map(salesman,AddSalesmanResponse.class);
        return addSalesmanResponse;
    }
}

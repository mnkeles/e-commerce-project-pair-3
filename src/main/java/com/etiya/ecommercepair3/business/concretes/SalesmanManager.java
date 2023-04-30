package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.SalesmanService;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.AddSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.UpdateSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.AddSalesmanRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.UpdateSalesmanRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Salesman;
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
    public DataResult<List<ListSalesmanResponse>> getAll() {
        return new SuccessDataResult<>(salesmanDao.getAll());
    }

    @Override
    public DataResult<SalesmanDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(salesmanDao.getBySalesmanId(id));
    }

    @Override
    public DataResult<AddSalesmanResponse> addSalesman(AddSalesmanRequest addSalesmanRequest) {
        // iş kuralı

        Salesman salesman=modelMapperService.forRequest().map(addSalesmanRequest,Salesman.class);
        salesmanDao.save(salesman);
        AddSalesmanResponse addSalesmanResponse=modelMapperService.forResponse().map(salesman,AddSalesmanResponse.class);
        return new SuccessDataResult<>(addSalesmanResponse);
    }

    @Override
    public DataResult<UpdateSalesmanResponse> updateSalesman(UpdateSalesmanRequest updateSalesmanRequest){
        // iş kuralı
        Salesman salesman=modelMapperService.forRequest().map(updateSalesmanRequest,Salesman.class);
        salesman.setId(updateSalesmanRequest.getId());
        salesmanDao.save(salesman);
        UpdateSalesmanResponse updateSalesmanResponse=modelMapperService.forResponse().map(salesman,UpdateSalesmanResponse.class);
        return new SuccessDataResult<>(updateSalesmanResponse);
    }

    @Override
    public Result deleteSalesman(Integer id){
        salesmanDao.deleteById(id);
        return new SuccessResult("X");
    }
}

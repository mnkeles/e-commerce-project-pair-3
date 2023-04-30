package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.SupplierService;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.AddSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.ListSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.SupplierDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.UpdateSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.supplier.AddSupplierRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.supplier.UpdateSupplierRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Supplier;
import com.etiya.ecommercepair3.repositories.abstracts.SupplierDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierManager implements SupplierService {

    private final SupplierDao supplierDao;

    private final ModelMapperService modelMapperService;
    @Override
    public DataResult<List<ListSupplierResponse>> getAll() {
        return new SuccessDataResult<>(supplierDao.getAll());
    }

    @Override
    public DataResult<SupplierDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(supplierDao.getBySupplierId(id));
    }

    @Override
    public DataResult<AddSupplierResponse> addSupplier(AddSupplierRequest addSupplierRequest) {
        // iş kuralı

        Supplier supplier=modelMapperService.forRequest().map(addSupplierRequest,Supplier.class);
        supplierDao.save(supplier);
        AddSupplierResponse addSupplierResponse=modelMapperService.forResponse().map(supplier, AddSupplierResponse.class);


        return new SuccessDataResult<>(addSupplierResponse);
    }
    @Override
    public DataResult<UpdateSupplierResponse> updateSupplier(UpdateSupplierRequest updateSupplierRequest){
        // iş kuralı
        Supplier supplier=modelMapperService.forRequest().map(updateSupplierRequest,Supplier.class);
        supplier.setId(updateSupplierRequest.getId());
        supplierDao.save(supplier);
        UpdateSupplierResponse updateCityResponse=modelMapperService.forResponse().map(supplier,UpdateSupplierResponse.class);
        return new SuccessDataResult<>(updateCityResponse);
    }

    @Override
    public Result deleteSupplier(Integer id){
        supplierDao.deleteById(id);
        return new SuccessResult("X");
    }

}

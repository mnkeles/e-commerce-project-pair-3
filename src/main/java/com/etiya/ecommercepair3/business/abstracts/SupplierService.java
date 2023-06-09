package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.supplier.AddSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.ListSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.SupplierDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.UpdateSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.supplier.AddSupplierRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.supplier.UpdateSupplierRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface SupplierService {

    DataResult<Slice<ListSupplierResponse>> getAll(Pageable pageable);
    DataResult<SupplierDetailResponse> getById(Integer id);

    DataResult<AddSupplierResponse> addSupplier(AddSupplierRequest addSupplierRequest);

    DataResult<UpdateSupplierResponse> updateSupplier(UpdateSupplierRequest updateSupplierRequest);

    Result deleteSupplier(Integer id);
}

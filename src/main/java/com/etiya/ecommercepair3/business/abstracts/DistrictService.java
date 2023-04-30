package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.district.AddDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.UpdateDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.district.AddDistrictRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.district.UpdateDistrictRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface DistrictService {
    DataResult<List<ListDistrictResponse>> getAll();
    DataResult<DistrictDetailResponse> getById(Integer id);
    DataResult<AddDistrictResponse> addDistrict(AddDistrictRequest addDistrictRequest);

    DataResult<UpdateDistrictResponse> updateDistrict(UpdateDistrictRequest updateDistrictRequest);

    Result deleteDistrict(Integer id);
}

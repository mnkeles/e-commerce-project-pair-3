package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.district.AddDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.district.AddDistrictRequest;

import java.util.List;

public interface DistrictService {
    List<ListDistrictResponse> getAll();
    DistrictDetailResponse getById(Integer id);
    AddDistrictResponse addDistrict(AddDistrictRequest addDistrictRequest);

}

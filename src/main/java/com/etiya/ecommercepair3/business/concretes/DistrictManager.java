package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.DistrictService;
import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.AddDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.district.AddDistrictRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concrete.Country;
import com.etiya.ecommercepair3.entities.concrete.District;
import com.etiya.ecommercepair3.repositories.abstracts.DistrictDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictManager implements DistrictService {
    private final DistrictDao districtDao;
    private final ModelMapperService modelMapperService;
    @Override
    public List<ListDistrictResponse> getAll() {
        return districtDao.getAll();
    }

    @Override
    public DistrictDetailResponse getById(Integer id) {
        return districtDao.getByDistrictId(id);
    }

    @Override
    public AddDistrictResponse addDistrict(AddDistrictRequest addDistrictRequest) {
        District district=modelMapperService.forRequest().map(addDistrictRequest,District.class);
        districtDao.save(district);
        AddDistrictResponse addDistrictResponse=modelMapperService.forResponse().map(district,AddDistrictResponse.class);
        return addDistrictResponse;
    }
}

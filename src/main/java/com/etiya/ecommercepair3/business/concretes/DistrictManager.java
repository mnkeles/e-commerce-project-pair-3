package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.DistrictService;
import com.etiya.ecommercepair3.business.dtos.responses.district.AddDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.UpdateDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.district.AddDistrictRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.district.UpdateDistrictRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.District;
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
    public DataResult<List<ListDistrictResponse>> getAll() {
        return new SuccessDataResult<>(districtDao.getAll());
    }

    @Override
    public DataResult<DistrictDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(districtDao.getByDistrictId(id));
    }

    @Override
    public DataResult<AddDistrictResponse> addDistrict(AddDistrictRequest addDistrictRequest) {
        District district=modelMapperService.forRequest().map(addDistrictRequest,District.class);
        districtDao.save(district);
        AddDistrictResponse addDistrictResponse=modelMapperService.forResponse().map(district,AddDistrictResponse.class);
        return new SuccessDataResult<>(addDistrictResponse);
    }

    @Override
    public DataResult<UpdateDistrictResponse> updateDistrict(UpdateDistrictRequest updateDistrictRequest){
        // iş kuralı
        District district=modelMapperService.forRequest().map(updateDistrictRequest,District.class);
        district.setId(updateDistrictRequest.getId());
        districtDao.save(district);
        UpdateDistrictResponse updateDistrictResponse=modelMapperService.forResponse().map(district,UpdateDistrictResponse.class);
        return new SuccessDataResult<>(updateDistrictResponse);
    }

    @Override
    public Result deleteDistrict(Integer id){
        districtDao.deleteById(id);
        return new SuccessResult("X");
    }
}

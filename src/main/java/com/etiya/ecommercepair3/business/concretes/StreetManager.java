package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.StreetService;
import com.etiya.ecommercepair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.UpdateStreetResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.street.AddStreetRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.street.UpdateStreetRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Street;
import com.etiya.ecommercepair3.repositories.abstracts.StreetDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreetManager implements StreetService {
    private final StreetDao streetDao;
    private final ModelMapperService modelMapperService;


    @Override
    public DataResult<List<ListStreetResponse>> getAll() {
        return new SuccessDataResult<>(streetDao.getAll());
    }

    @Override
    public DataResult<StreetDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(streetDao.getByStreetId(id));
    }

    @Override
    public DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest) {

        Street street=modelMapperService.forRequest().map(addStreetRequest,Street.class);
        streetDao.save(street);
        AddStreetResponse addStreetResponse=modelMapperService.forResponse().map(street,AddStreetResponse.class);
        return new SuccessDataResult<>(addStreetResponse);
    }

    @Override
    public DataResult<UpdateStreetResponse> updateStreet(UpdateStreetRequest updateStreetRequest){
        // iş kuralı
        Street street=modelMapperService.forRequest().map(updateStreetRequest,Street.class);
        street.setId(updateStreetRequest.getId());
        streetDao.save(street);
        UpdateStreetResponse updateStreetResponse=modelMapperService.forResponse().map(street,UpdateStreetResponse.class);
        return new SuccessDataResult<>(updateStreetResponse);
    }

    @Override
    public Result deleteStreet(Integer id){
        streetDao.deleteById(id);
        return new SuccessResult("X");
    }
}

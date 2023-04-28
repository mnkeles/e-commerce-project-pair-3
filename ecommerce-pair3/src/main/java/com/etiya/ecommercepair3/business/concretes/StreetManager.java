package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.StreetService;
import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailsResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.street.AddStreetRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concrete.Country;
import com.etiya.ecommercepair3.entities.concrete.Street;
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
    public List<ListStreetResponse> getAll() {
        return streetDao.getAll();
    }

    @Override
    public StreetDetailsResponse getById(Integer id) {
        return streetDao.getByStreetId(id);
    }

    @Override
    public AddStreetResponse addStreet(AddStreetRequest addStreetRequest) {

        Street street=modelMapperService.forRequest().map(addStreetRequest,Street.class);
        streetDao.save(street);
        AddStreetResponse addStreetResponse=modelMapperService.forResponse().map(street,AddStreetResponse.class);
        return addStreetResponse;
    }
}

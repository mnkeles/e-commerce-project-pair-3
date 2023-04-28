package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailsResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.street.AddStreetRequest;

import java.util.List;

public interface StreetService {
    List<ListStreetResponse> getAll();

    StreetDetailsResponse getById(Integer id);

    AddStreetResponse addStreet(AddStreetRequest addStreetRequest);


}

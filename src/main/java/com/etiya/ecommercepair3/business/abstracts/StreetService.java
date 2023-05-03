package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.UpdateStreetResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.street.AddStreetRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.street.UpdateStreetRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface StreetService {
    DataResult<Slice<ListStreetResponse>> getAll(Pageable pageable);

    DataResult<StreetDetailResponse> getById(Integer id);

    DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest);


    DataResult<UpdateStreetResponse> updateStreet(UpdateStreetRequest updateStreetRequest);

    Result deleteStreet(Integer id);
}

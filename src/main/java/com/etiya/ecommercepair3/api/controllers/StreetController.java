package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.StreetService;
import com.etiya.ecommercepair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailsResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.street.AddStreetRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/street")
@RequiredArgsConstructor
public class StreetController {
    private final StreetService streetService;

    @GetMapping()
    public List<ListStreetResponse> getAll(){
        return streetService.getAll();
    }

    @GetMapping("/{id}")
    public StreetDetailsResponse getById(@PathVariable Integer id){
        return streetService.getById(id);
    }

    @PostMapping("/add")
    public AddStreetResponse addStreet(AddStreetRequest addStreetRequest){
        return streetService.addStreet(addStreetRequest);
    }
}

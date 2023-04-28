package com.etiya.ecommercepair3.core.utils.maping;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
    // Model Mapper isimleri aynı olan alanrı eşitler, belirsiz olan alanları ignorlayabiliriz
    // Örneğin Address ve AddAddressResponse da id kısımları eşitlenir
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE)
                .setFieldMatchingEnabled(true)
                .setAmbiguityIgnored(true);  // Belirsiz alanları Ignore et
        return modelMapper;
    }
    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setFieldMatchingEnabled(true)
                .setAmbiguityIgnored(true);  // Belirsiz alanları Ignore et
        return modelMapper;
    }
}

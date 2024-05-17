package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.internal.*;
import org.cakejoy.backend.repository.AdditionalOptionsRepository;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AdditionalOptionsMapper {

    private final AdditionalOptionsRepository additionalOptionsRepository;

    public AdditionalOptionsMapper(AdditionalOptionsRepository additionalOptionsRepository) {
        this.additionalOptionsRepository = additionalOptionsRepository;
    }

    public AdditionalOptions mapToEntity(String additionalOptions) {
        return additionalOptionsRepository.findAdditionalOptionsByName(additionalOptions);
    }

    public Set<String> mapAddOptionsToDTONames(Set<AdditionalOptions> additionalOptions) {
        return additionalOptions.stream()
                .map(AdditionalOptions::getName)
                .collect(Collectors.toSet());
    }

    public Set<AdditionalOptions> mapDTOToAdditionalOptions(Set<String> additionalOptionsDTOs) {
        return additionalOptionsDTOs.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toSet());
    }

}

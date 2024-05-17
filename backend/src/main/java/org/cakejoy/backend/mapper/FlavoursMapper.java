package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.internal.Flavour;
import org.cakejoy.backend.repository.FlavoursRepository;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FlavoursMapper {

    private final FlavoursRepository flavoursRepository;

    public FlavoursMapper(FlavoursRepository flavoursRepository) {
        this.flavoursRepository = flavoursRepository;
    }

    public Set<String> mapFlavoursToDTONames(Set<Flavour> flavours) {
        return flavours.stream()
                .map(Flavour::getName)
                .collect(Collectors.toSet());
    }

    public Flavour mapToEntity(String flavourDTO) {
        return flavoursRepository.findFlavourByName(flavourDTO);
    }

    public Set<Flavour> mapDTOToFlavours(Set<String> flavourDTOs) {
        return flavourDTOs.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toSet());
    }

}

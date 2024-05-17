package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.external.DecorationDTO;
import org.cakejoy.backend.api.external.GlazeDTO;
import org.cakejoy.backend.api.external.GlazeOrderDTO;
import org.cakejoy.backend.api.internal.*;
import org.cakejoy.backend.repository.GlazeOrderRepository;
import org.cakejoy.backend.repository.GlazeRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GlazeMapper {

    private final GlazeRepository glazeRepository;

    public GlazeMapper(GlazeRepository glazeRepository) {
        this.glazeRepository = glazeRepository;
    }

    public Set<String> mapGlazeToDTONames(Set<Glaze> glazes) {
        return glazes.stream()
                .map(Glaze::getName)
                .collect(Collectors.toSet());
    }

    public Glaze mapToEntity(String glazeDTO) {
        return glazeRepository.findGlazeByName(glazeDTO);
    }

    public Set<Glaze> mapDTOToGlazes(Set<String> glazeDTOs) {
        return glazeDTOs.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toSet());
    }
}

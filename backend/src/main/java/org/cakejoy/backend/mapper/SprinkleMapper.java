package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.internal.Sprinkle;
import org.cakejoy.backend.repository.SprinkleRepository;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SprinkleMapper {

    private final SprinkleRepository sprinkleRepository;

    public SprinkleMapper(SprinkleRepository sprinkleRepository) {
        this.sprinkleRepository = sprinkleRepository;
    }

    public Set<String> mapSprinklesToDTONames(Set<Sprinkle> sprinkles) {
        return sprinkles.stream()
                .map(Sprinkle::getName)
                .collect(Collectors.toSet());
    }

    public Sprinkle mapToEntity(String sprinkleDTO) {
        return sprinkleRepository.findSprinkleByName(sprinkleDTO);
    }

    public Set<Sprinkle> mapDTOToSprinkles(Set<String> sprinkleDTOs) {
        return sprinkleDTOs.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toSet());
    }
}

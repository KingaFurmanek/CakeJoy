package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.external.DecorationDTO;
import org.cakejoy.backend.api.external.DecorationsOrderDTO;
import org.cakejoy.backend.api.internal.Decoration;
import org.cakejoy.backend.api.internal.DecorationsOrder;
import org.cakejoy.backend.api.internal.Orders;
import org.cakejoy.backend.repository.DecorationsRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DecorationMapper {

    private final DecorationsRepository decorationsRepository;

    public DecorationMapper(DecorationsRepository decorationsRepository) {
        this.decorationsRepository = decorationsRepository;
    }

    public Set<String> mapDecorationsToNames(Set<Decoration> decorations){
        return decorations.stream()
                .map(Decoration::getName)
                .collect(Collectors.toSet());
    }

    public Decoration mapToEntity(String decoration) {
        return decorationsRepository.findDecorationByName(decoration);
    }

    public Set<Decoration> mapDTOToDecorations(Set<String> decorations) {
        return decorations.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toSet());
    }


}

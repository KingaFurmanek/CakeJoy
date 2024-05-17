package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.external.CategoryDTO;
import org.cakejoy.backend.api.external.OrdersDTO;
import org.cakejoy.backend.api.internal.Address;
import org.cakejoy.backend.api.internal.Category;
import org.cakejoy.backend.api.internal.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrdersMapper {

    private final CategoryMapper categoryMapper;
    private final DecorationMapper decorationMapper;
    private final AdditionalOptionsMapper additionalOptionsMapper;
    private final SprinkleMapper sprinkleMapper;
    private final GlazeMapper glazeMapper;
    private final FlavoursMapper flavoursMapper;

    public OrdersMapper(CategoryMapper categoryMapper, DecorationMapper decorationMapper, AdditionalOptionsMapper additionalOptionsMapper, SprinkleMapper sprinkleMapper, GlazeMapper glazeMapper, FlavoursMapper flavoursMapper) {
        this.categoryMapper = categoryMapper;
        this.decorationMapper = decorationMapper;
        this.additionalOptionsMapper = additionalOptionsMapper;
        this.sprinkleMapper = sprinkleMapper;
        this.glazeMapper = glazeMapper;
        this.flavoursMapper = flavoursMapper;
    }

    public OrdersDTO map(Orders orders) {
        Category category = orders.getCategory();

        return new OrdersDTO()
        .setId(orders.getId())
        .setAdditionalInfo(orders.getAdditionalInfo())
        .setDate(orders.getDate())
        .setOccasion(orders.getOccasion())
        .setColours(orders.getColours())
        .setQuantity(orders.getQuantity())
        .setTiers(orders.getTiers())
        .setCategory(category.getName())
        .setDecorations(decorationMapper.mapDecorationsToNames(orders.getDecorations()))
        .setAdditionalOptions(additionalOptionsMapper.mapAddOptionsToDTONames(orders.getAdditionalOptions()))
        .setFlavours(flavoursMapper.mapFlavoursToDTONames(orders.getFlavours()))
        .setSprinkles(sprinkleMapper.mapSprinklesToDTONames(orders.getSprinkles()))
        .setGlazes(glazeMapper.mapGlazeToDTONames(orders.getGlazes()));
    }

    public Orders map(OrdersDTO ordersDTO) {

        return new Orders()
                .setId(ordersDTO.getId())
                .setAdditionalInfo(ordersDTO.getAdditionalInfo())
                .setDate(ordersDTO.getDate())
                .setOccasion(ordersDTO.getOccasion())
                .setColours(ordersDTO.getColours())
                .setQuantity(ordersDTO.getQuantity())
                .setTiers(ordersDTO.getTiers())
                .setCategory(categoryMapper.map(ordersDTO.getCategory()))
                .setDecorations(decorationMapper.mapDTOToDecorations(ordersDTO.getDecorations()))
                .setAdditionalOptions(additionalOptionsMapper.mapDTOToAdditionalOptions(ordersDTO.getAdditionalOptions()))
                .setFlavours(flavoursMapper.mapDTOToFlavours(ordersDTO.getFlavours()))
                .setSprinkles(sprinkleMapper.mapDTOToSprinkles(ordersDTO.getSprinkles()))
                .setGlazes(glazeMapper.mapDTOToGlazes(ordersDTO.getGlazes()));
    }
}

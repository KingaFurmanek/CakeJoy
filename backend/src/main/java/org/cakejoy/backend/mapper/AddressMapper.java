package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.internal.Address;
import org.cakejoy.backend.api.external.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO map(Address address, Integer userId) {
        return new AddressDTO()
                .setId(address.getId())
                .setUserId(userId)
                .setCountry(address.getCountry())
                .setPostcode(address.getPostcode())
                .setCity(address.getCity())
                .setStreet(address.getStreet())
                .setNumber(address.getNumber());
    }

}

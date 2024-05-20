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

    public void map(AddressDTO addressDTO, Address address) {
        if (addressDTO != null) {
            address.setCountry(addressDTO.getCountry());
            address.setPostcode(addressDTO.getPostcode());
            address.setCity(addressDTO.getCity());
            address.setStreet(addressDTO.getStreet());
            address.setNumber(addressDTO.getNumber());
        }
    }

}

package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.external.UsersDTO;
import org.cakejoy.backend.api.internal.Address;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.service.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    private final AddressMapper addressMapper;

    public UsersMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public UsersDTO map(Users user) {
        Address address = user.getAddress();
        return new UsersDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setImage(FileUtils.readFileFromLocation(user.getImage()))
                .setAddress(addressMapper.map(address, user.getId()));
    }

}

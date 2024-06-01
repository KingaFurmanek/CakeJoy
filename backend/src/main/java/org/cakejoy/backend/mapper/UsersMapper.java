package org.cakejoy.backend.mapper;

import org.cakejoy.backend.api.external.UsersDTO;
import org.cakejoy.backend.api.external.UsersRoleDTO;
import org.cakejoy.backend.api.internal.Address;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.repository.UserRoleRepository;
import org.cakejoy.backend.service.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    private final AddressMapper addressMapper;
    private final UserRoleRepository userRoleRepository;

    public UsersMapper(AddressMapper addressMapper, UserRoleRepository userRoleRepository) {
        this.addressMapper = addressMapper;
        this.userRoleRepository = userRoleRepository;
    }

    public UsersDTO map(Users user) {
        Address address = user.getAddress();
        UsersRoleDTO roleDTO = userRoleRepository.findNameById(user.getUserRole().getId());
        return new UsersDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setEmail(user.getEmail())
                .setImage(FileUtils.readFileFromLocation(user.getImage()))
                .setAddress(addressMapper.map(address, user.getId()))
                .setRole(roleDTO);
    }
}


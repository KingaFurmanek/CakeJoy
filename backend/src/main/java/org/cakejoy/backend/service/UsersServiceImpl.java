package org.cakejoy.backend.service;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.AddressDTO;
import org.cakejoy.backend.api.external.UsersDTO;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.mapper.UsersMapper;
import org.cakejoy.backend.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    @Override
    public AddressDTO getUserAddress(Integer userId) {
        Users user = usersRepository.findById(userId).orElse(null);
        if (user != null) {
            return usersMapper.map(user.getAddress().getUser()).getAddress();
        }
        return null;
    }

    @Override
    public UsersDTO getUserByEmail(String email) {
        Users user = usersRepository.findUserByEmail(email).orElse(null);
        if (user != null)
            return usersMapper.map(user);
        return null;
    }
}


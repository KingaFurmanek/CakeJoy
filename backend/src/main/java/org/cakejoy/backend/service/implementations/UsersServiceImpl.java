package org.cakejoy.backend.service.implementations;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.AddressDTO;
import org.cakejoy.backend.api.external.UsersDTO;
import org.cakejoy.backend.api.internal.Address;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.mapper.AddressMapper;
import org.cakejoy.backend.mapper.UsersMapper;
import org.cakejoy.backend.repository.AddressRepository;
import org.cakejoy.backend.repository.UsersRepository;
import org.cakejoy.backend.service.FileStorageService;
import org.cakejoy.backend.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    private final FileStorageService fileStorageService;

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
        if (user != null) {
            return usersMapper.map(user);
        }
        return null;
    }

    @Override
    public boolean editUserAddress(String email, AddressDTO updatedAddress) {
        Users user = usersRepository.findUserByEmail(email).orElse(null);
        if (user != null) {
            Address address = user.getAddress();
            if (address == null) {
                address = new Address();
                address.setUser(user);
            }
            addressMapper.map(updatedAddress, address);
            addressRepository.save(address);
            return true;
        }
        return false;
    }

    @Override
    public void updateUserPhoto(String email, MultipartFile file) {
        Users user = usersRepository.findUserByEmail(email).orElse(null);
        if (user != null) {
            String filePath = fileStorageService.saveFile(file);
            user.setImage(filePath);
            usersRepository.save(user);
        }
    }
}


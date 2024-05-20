package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.AddressDTO;
import org.cakejoy.backend.api.external.UsersDTO;

public interface UsersService {
    AddressDTO getUserAddress(Integer userId);
    UsersDTO getUserByEmail(String email);
    boolean editUserAddress(String email, AddressDTO updatedAddress);
}
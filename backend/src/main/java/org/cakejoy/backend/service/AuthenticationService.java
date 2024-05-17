package org.cakejoy.backend.service;

import org.cakejoy.backend.api.external.AuthenticationRequest;
import org.cakejoy.backend.api.external.AuthenticationResponse;
import org.cakejoy.backend.api.external.RegisterRequest;
import org.cakejoy.backend.api.external.UsersDTO;
import org.springframework.stereotype.Service;


public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(AuthenticationRequest request);

    UsersDTO verify();
}

package org.cakejoy.backend.service.implementations;

import lombok.RequiredArgsConstructor;
import org.cakejoy.backend.api.external.AuthenticationRequest;
import org.cakejoy.backend.api.external.AuthenticationResponse;
import org.cakejoy.backend.api.external.RegisterRequest;
import org.cakejoy.backend.api.external.UsersDTO;
import org.cakejoy.backend.api.internal.Address;
import org.cakejoy.backend.api.internal.UserRole;
import org.cakejoy.backend.api.internal.Users;
import org.cakejoy.backend.mapper.UsersMapper;
import org.cakejoy.backend.repository.UserRoleRepository;
import org.cakejoy.backend.repository.UsersRepository;
import org.cakejoy.backend.service.AuthenticationService;
import org.cakejoy.backend.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UsersRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UsersMapper userMapper;


    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User already exists!");
        }

        UserRole userRole = userRoleRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("User role not found!"));

        Users user = new Users();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setSurname(request.getName());
        user.setName(request.getName());
        user.setUserRole(userRole);

        Address address = new Address();
        address.setCountry(request.getCountry());
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        address.setPostcode(request.getPostcode());
        address.setNumber(request.getNumber());
        address.setUser(user);

        user.setAddress(address);
        userRepository.save(user);

        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var jwt = jwtService.generateToken(user);

        String userRole = user.getUserRole().getName();

        return AuthenticationResponse.builder()
                .token(jwt)
                .role(userRole)
                .build();
    }

    @Override
    public UsersDTO verify() {
        var user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userMapper.map(user);
    }
}

package com.ecommerce.service.impl;

import com.ecommerce.config.JwtService;
import com.ecommerce.dto.request.AuthenticationRequest;
import com.ecommerce.dto.response.AuthenticationResponse;
import com.ecommerce.dto.response.BaseResponse;
import com.ecommerce.enums.Status;
import com.ecommerce.model.User;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ecommerce.constants.UserConstant.USER_AUTHENTICATE_SUCCESS;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public BaseResponse<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        User user=userRepository.findByEmailAndStatus(request.getEmail(), Status.ACTIVE)
                .orElseThrow();
        String jwtToken=jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder().token(jwtToken).build();
        return new BaseResponse<>(HttpStatus.OK.value(),USER_AUTHENTICATE_SUCCESS,authenticationResponse,null);
    }
}

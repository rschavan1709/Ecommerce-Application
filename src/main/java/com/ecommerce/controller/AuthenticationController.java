package com.ecommerce.controller;

import com.ecommerce.dto.request.AuthenticationRequest;
import com.ecommerce.dto.response.AuthenticationResponse;
import com.ecommerce.dto.response.BaseResponse;
import com.ecommerce.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<BaseResponse<AuthenticationResponse>> authenticate(@RequestBody @Valid AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}

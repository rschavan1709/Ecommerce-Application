package com.ecommerce.service;

import com.ecommerce.dto.request.AuthenticationRequest;
import com.ecommerce.dto.response.AuthenticationResponse;
import com.ecommerce.dto.response.BaseResponse;

public interface AuthenticationService {

    public BaseResponse<AuthenticationResponse> authenticate(AuthenticationRequest request);

}

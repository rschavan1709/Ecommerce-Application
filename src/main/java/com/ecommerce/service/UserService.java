package com.ecommerce.service;

import com.ecommerce.dto.request.UserRequest;
import com.ecommerce.dto.response.BaseResponse;
import com.ecommerce.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    public BaseResponse<UserResponse> addUser(UserRequest userRequest);

    public BaseResponse<UserResponse> getUser(Integer id);

    public BaseResponse<List<UserResponse>> getAllUsers();

    public BaseResponse<Void> deleteUser(Integer id);

    public BaseResponse<UserResponse> updateUser(Integer id,UserRequest userRequest);
}

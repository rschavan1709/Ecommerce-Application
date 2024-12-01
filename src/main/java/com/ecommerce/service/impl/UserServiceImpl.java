package com.ecommerce.service.impl;

import com.ecommerce.dto.request.UserRequest;
import com.ecommerce.dto.response.BaseResponse;
import com.ecommerce.dto.response.UserResponse;
import com.ecommerce.exceptions.ModelNotFoundException;
import com.ecommerce.model.User;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.constants.UserConstant.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public BaseResponse<UserResponse> addUser(UserRequest userRequest) {
        User user = User.builder().build();
        BeanUtils.copyProperties(userRequest,user);
        user = userRepository.save(user);
        UserResponse userResponse = UserResponse.builder().build();
        BeanUtils.copyProperties(user,userResponse);
        return new BaseResponse<>(HttpStatus.CREATED.value(), USER_CREATED_SUCCESS,userResponse,null);
    }

    @Override
    public BaseResponse<UserResponse> getUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(USER_NOT_FOUND));
        UserResponse userResponse = UserResponse.builder().build();
        BeanUtils.copyProperties(user,userResponse);
        return new BaseResponse<>(HttpStatus.FOUND.value(),USER_FOUND_SUCCESS,userResponse,null);
    }

    @Override
    public BaseResponse<List<UserResponse>> getAllUsers() {
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty())
            return new BaseResponse<>(HttpStatus.OK.value(), USERS_NOT_FOUND_IN_LIST,null,null);
        List<UserResponse> userResponseList = new ArrayList<>();
        for(User user:userList) {
            UserResponse userResponse = UserResponse.builder().build();
            BeanUtils.copyProperties(user, userResponse);
            userResponseList.add(userResponse);
        }
        return new BaseResponse<>(HttpStatus.OK.value(), USERS_FETCH_SUCCESS,userResponseList,null);
    }

    @Override
    public BaseResponse<String> deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(USER_NOT_FOUND));
        userRepository.delete(user);
        return new BaseResponse<>(HttpStatus.OK.value(), USER_DELETE_SUCCESS,null,null);
    }
}

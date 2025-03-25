package com.ecommerce.service.impl;

import com.ecommerce.dto.request.UserRequest;
import com.ecommerce.dto.response.BaseResponse;
import com.ecommerce.dto.response.UserResponse;
import com.ecommerce.exceptions.ModelNotFoundException;
import com.ecommerce.model.User;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.constants.UserConstant.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public BaseResponse<UserResponse> addUser(UserRequest userRequest) {
        log.info("Inside addUser method");
        User user = User.builder().build();
        BeanUtils.copyProperties(userRequest,user);
        user.setAge(Integer.valueOf(userRequest.getAge()));
        user = userRepository.save(user);
        UserResponse userResponse = UserResponse.builder().build();
        BeanUtils.copyProperties(user,userResponse);
        return new BaseResponse<>(HttpStatus.CREATED.value(), USER_CREATED_SUCCESS,userResponse,null);
    }

    @Override
    public BaseResponse<UserResponse> getUser(Integer id) {
        log.info("Inside getUser method");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(USER_NOT_FOUND));
        UserResponse userResponse = UserResponse.builder().build();
        BeanUtils.copyProperties(user,userResponse);
        return new BaseResponse<>(HttpStatus.FOUND.value(),USER_FOUND_SUCCESS,userResponse,null);
    }

    @Override
    public BaseResponse<List<UserResponse>> getAllUsers() {
        log.info("Inside getAllUsers method");
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
    public BaseResponse<Void> deleteUser(Integer id) {
        log.info("Inside deleteUser method");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(USER_NOT_FOUND));
        userRepository.delete(user);
        return new BaseResponse<>(HttpStatus.OK.value(), USER_DELETE_SUCCESS,null,null);
    }

    @Override
    public BaseResponse<UserResponse> updateUser(Integer id, UserRequest userRequest) {
        log.info("Inside updateUser method");
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(USER_NOT_FOUND));
        existingUser.setFirstName(userRequest.getFirstName());
        existingUser.setLastName(userRequest.getLastName());
        existingUser.setGender(userRequest.getGender());
        existingUser.setCity(userRequest.getCity());
        existingUser.setAge(Integer.valueOf(userRequest.getAge()));
        User savedUser = userRepository.save(existingUser);
        UserResponse userResponse = UserResponse.builder().build();
        BeanUtils.copyProperties(savedUser,userResponse);
        return new BaseResponse<>(HttpStatus.OK.value(),USER_UPDATE_SUCCESS,userResponse,null);
    }
}

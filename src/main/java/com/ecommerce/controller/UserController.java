package com.ecommerce.controller;

import com.ecommerce.dto.request.UserRequest;
import com.ecommerce.dto.response.BaseResponse;
import com.ecommerce.dto.response.UserResponse;
import com.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<UserResponse>> registerUser(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(userRequest));
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse<List<UserResponse>>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<UserResponse>> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<UserResponse>> updateUser(@PathVariable Integer id,@RequestBody @Valid UserRequest userRequest ){
        return ResponseEntity.ok(userService.updateUser(id,userRequest));
    }

}

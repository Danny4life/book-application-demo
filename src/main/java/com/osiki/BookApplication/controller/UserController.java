package com.osiki.BookApplication.controller;

import com.osiki.BookApplication.dto.ApiResponse;
import com.osiki.BookApplication.dto.UserDto;
import com.osiki.BookApplication.dto.UserSignupResponse;
import com.osiki.BookApplication.model.User;
import com.osiki.BookApplication.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(@Valid @RequestBody UserDto userDto) {

        return userService.register(userDto);
    }
}

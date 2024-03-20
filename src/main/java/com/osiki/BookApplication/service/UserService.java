package com.osiki.BookApplication.service;

import com.osiki.BookApplication.dto.ApiResponse;
import com.osiki.BookApplication.dto.UserDto;
import com.osiki.BookApplication.dto.UserSignupResponse;
import com.osiki.BookApplication.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    //User registerUser(UserDto userDto);

    ResponseEntity<ApiResponse<UserSignupResponse>> register(UserDto userDto);
}

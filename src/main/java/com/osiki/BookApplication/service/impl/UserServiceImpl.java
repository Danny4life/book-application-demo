package com.osiki.BookApplication.service.impl;

import com.osiki.BookApplication.dto.ApiResponse;
import com.osiki.BookApplication.dto.UserDto;
import com.osiki.BookApplication.dto.UserSignupResponse;
import com.osiki.BookApplication.enums.Gender;
import com.osiki.BookApplication.enums.Role;
import com.osiki.BookApplication.exceptions.EmailAlreadyExistsException;
import com.osiki.BookApplication.exceptions.PasswordNotMatchException;
import com.osiki.BookApplication.model.User;
import com.osiki.BookApplication.repository.UserRepository;
import com.osiki.BookApplication.service.UserService;
import com.osiki.BookApplication.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
  //  private final Util util;


//    @Override
//    public User registerUser(UserDto userDto) {
//        boolean userExists = userRepository.findByEmail(userDto.getEmail()).isPresent();
//        boolean isPasswordMatch = util.validatePassword(userDto.getPassword(), userDto.getConfirmPassword());
//
//        if(userExists){
//            throw new EmailAlreadyExistsException("Email Already exists. kindly log into your account");
//        }
//
//        if(!isPasswordMatch){
//            throw new PasswordNotMatchException("Passwords do not match");
//        }
//
//        User user = User.builder()
//                .firstname(userDto.getFirstname())
//                .lastname(userDto.getLastname())
//                .email(userDto.getEmail())
//                .role(Role.USER)
//                .password(userDto.getPassword())
//                .build();
//
//        userRepository.save(user);
//
//        return user;
//    }

    @Override
    public ResponseEntity<ApiResponse<UserSignupResponse>> register(UserDto userDto) {

        boolean userExists = userRepository.findByEmail(userDto.getEmail()).isPresent();
       // boolean isPasswordMatch = util.validatePassword(userDto.getPassword(), userDto.getConfirmPassword());

        if(userExists){
            throw new EmailAlreadyExistsException("Email Already exists. kindly log into your account");
        }

//        if(!isPasswordMatch){
//            throw new PasswordNotMatchException("Passwords do not match");
//        }

        User user = User.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .role(Role.USER)
                .password(userDto.getPassword())
                .gender(Gender.valueOf(String.valueOf(userDto.getGender())))
                .build();

        userRepository.save(user);

        UserSignupResponse userSignupResponse = UserSignupResponse.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .build();


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Account created successfully", userSignupResponse));
    }
}

package com.osiki.BookApplication.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupResponse {


    private String firstname;

    private String lastname;

    private String email;

}

package com.fullhouse.studentmanagerment.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;


    private String email;


    private String password;

    private String confirmPass;


}

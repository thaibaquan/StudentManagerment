package com.fullhouse.studentmanagerment.controllers;

import com.fullhouse.studentmanagerment.dtos.UserDto;
import com.fullhouse.studentmanagerment.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class registerUser {
    @Autowired
    private UserService userService;
    @ModelAttribute("userdto")
    public UserDto userRegistationDto(){
        return new UserDto();
    }

    @GetMapping("/register")
    public String showFormRegister(){
        return "register-user";
    }
    @PostMapping("/register")
    public  String registrationUser(@ModelAttribute("userdto") UserDto userDto){

        if(userService.checkUserByEmail(userDto.getEmail())){
            return "redirect:/register?emailexist";
        }
        if(userDto.getPassword().equals(userDto.getConfirmPass()) == false){
            return "redirect:/register?checkpass";
        }
        userService.save(userDto);
        return "redirect:/register?success";
    }
}

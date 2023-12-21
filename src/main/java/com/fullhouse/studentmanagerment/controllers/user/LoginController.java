package com.fullhouse.studentmanagerment.controllers.user;

import com.fullhouse.studentmanagerment.dtos.UserDto;
import com.fullhouse.studentmanagerment.models.User;
import com.fullhouse.studentmanagerment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userdto") UserDto userDto, Model model)
    {
        if(userService.checkUserByEmail(userDto.getEmail()) == false){
            return "redirect:/login?error";
        }if(userService.checkPasswordUser(userDto.getEmail(),userDto.getPassword())){
            return "redirect:/admin/organization?success";
        }
        return "redirect:/login?error";
    }
}

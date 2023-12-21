//package com.fullhouse.studentmanagerment.sercurity;
//
//import com.fullhouse.studentmanagerment.models.User;
//import com.fullhouse.studentmanagerment.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Collectors;
//
//@Service
//public class CustomerUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    public CustomerUserDetailService(UserService userService){
//        this.userService = userService;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userService.findUserByEmail(email);
//        if (user != null) {
//            return org.springframework.security.core.userdetails.User.builder()
//                    .username(user.getEmail())
//                    .password(user.getPassword())
//                    .roles(user.getRole())
//                    .build();
//        }else {
//            throw new UsernameNotFoundException("Login found!");
//        }
//    }
//}

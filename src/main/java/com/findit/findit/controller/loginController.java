package com.findit.findit.controller;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findit.findit.models.registeredUsersModel;
import com.findit.findit.repository.registeredUsersRepo;

@RestController
@RequestMapping("/api")
public class loginController {

    @Autowired
    private registeredUsersRepo userModel;

    @PostMapping("/login")
    public ResponseEntity<String> loginCheck(@RequestBody registeredUsersModel req) {

        if(req.getEmail().length()==0){
            return ResponseEntity.badRequest().body("Email is required");
        }
        else{
            if(!userModel.existsByEmail(req.getEmail())){
                return ResponseEntity.badRequest().body("Invalid email id");
            }
            else{

                if(req.getPassword().length()==0){
                    return ResponseEntity.badRequest().body("Password is required");
                }
                else{
                    Optional<registeredUsersModel> userOption = userModel.findByEmail(req.getEmail());
                    registeredUsersModel user = userOption.get();
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    if(!passwordEncoder.matches(req.getPassword(), user.getHashedPassword())){
                        return ResponseEntity.badRequest().body("Invalid email id or password");
                    }
                }
            }
        }

        return ResponseEntity.ok("login successful");

    }
    
}

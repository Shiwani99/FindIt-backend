package com.findit.findit.controller;

import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.findit.findit.models.registeredUsers;

import java.util.regex.Matcher;

@RestController
@RequestMapping("/api")
public class registeredUsersController {

    public static boolean isValidName(String name) {
        String regex = "^[A-Za-z\\s\']+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        String alphabetRegex = ".*[a-zA-Z].*";
        String numberRegex = ".*\\d.*";
        String specialCharRegex = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";

        boolean hasAlphabet = password.matches(alphabetRegex);
        boolean hasNumber = password.matches(numberRegex);
        boolean hasSpecialChar = password.matches(specialCharRegex);

        return hasAlphabet && hasNumber && hasSpecialChar;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody registeredUsers req) {

        if (req.getFirstName().isEmpty()) {
            return ResponseEntity.badRequest().body("First name cannot be empty!!");
        }
    
        if (req.getLastName().isEmpty()) {
            return ResponseEntity.badRequest().body("Last name cannot be empty!!");
        }
    
        if (!isValidName(req.getFirstName())) {
            return ResponseEntity.badRequest().body("Enter a valid first name");
        }
        
        if (!isValidName(req.getLastName())) {
            return ResponseEntity.badRequest().body("Enter a valid last name");
        }
    
        if (!isValidEmail(req.getEmail())) {
            return ResponseEntity.badRequest().body("Enter a valid email");
        }
    
        if (req.getPassword().length() < 8) {
            return ResponseEntity.badRequest().body("Password too short");
        } else {
            if (!isValidPassword(req.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid password: password must contain a combination of alphabets, numbers, special characters");
            }
        }
    
    
        return ResponseEntity.ok("success");


    }
    
}

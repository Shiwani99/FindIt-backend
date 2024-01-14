package com.findit.findit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "registeredUsers")
public class registeredUsersModel {
    
    @Transient
    private String password;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first name")
    private String firstName;

    @Column(name = "last name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "hashedPassword")
    private String hashedPassword;

    @Column(name = "userType")
    private String userType;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setUserType(String userType){
        this.userType=userType;
    }


    public void setHashedPassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        this.hashedPassword = hashedPassword;
        this.password=password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }


    public String getEmail(){
        return this.email;
    }

    public String getUserType(){
        return this.userType;
    }
    
    
     public String getPassword(){
        return this.password;
    }


    public String getHashedPassword(){
        return this.hashedPassword;
    }

}

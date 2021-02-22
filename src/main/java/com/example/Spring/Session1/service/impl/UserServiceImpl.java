package com.example.Spring.Session1.service.impl;

import com.example.Spring.Session1.DTO.MyRequestDTO;
import com.example.Spring.Session1.DTO.MyResponseDTO;
import com.example.Spring.Session1.service.UserInterface;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserInterface {

    public UserServiceImpl() {
        System.out.println("Inside userservice constructor");
    }

    @PostConstruct
    public void init () {
        System.out.println("Inside UserService post construct");
    }

    @Override
    public boolean updateEmployee( MyRequestDTO request, String id)
    {
        System.out.println("Inside User Service: "+request+" "+id);
        return false;
    }
}

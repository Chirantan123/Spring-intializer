package com.example.Spring.Session1.controller;


import com.example.Spring.Session1.DTO.MyRequestDTO;
import com.example.Spring.Session1.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class Controller1 {
    //[POST] /update/employee/{Id}
    //{"FirstName":  ," "}

    public Controller1(UserInterface userInterface) {
        this.userInterface = userInterface;
        System.out.println("Inside Controller1 constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("Inside controller1 post constructor");
    }

    @Autowired
    private UserInterface userInterface;

    @PostMapping(value="/update/employee/{id}")
    public boolean updateEmployee(@PathVariable String id, @RequestBody MyRequestDTO request)
    {
        return userInterface.updateEmployee(request, id);
    }


}

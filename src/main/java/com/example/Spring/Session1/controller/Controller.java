package com.example.Spring.Session1.controller;

import com.example.Spring.Session1.DTO.MyRequestDTO;
import com.example.Spring.Session1.DTO.MyResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
    @PostMapping(path="/hello-post")
    public String hello(){
        return "post-mapping";
    }
    @GetMapping(path = "/hello-query")
    public String request(@RequestParam String query)
    {
        return "query" + query;
    }
    @PostMapping(value ="/register")
    public String registeruser(@RequestBody MyRequestDTO request)
    {
        return request.toString();
    }
    @GetMapping(path="/employee/{employeeId}")
    public MyResponseDTO getEmployeeDetatils(@PathVariable String employeeId){
        MyResponseDTO r = new MyResponseDTO();
        r.setId(employeeId);
        return r;
    }
}

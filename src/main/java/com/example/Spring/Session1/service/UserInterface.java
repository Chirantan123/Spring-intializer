package com.example.Spring.Session1.service;

import com.example.Spring.Session1.DTO.MyRequestDTO;
import com.example.Spring.Session1.DTO.MyResponseDTO;

public interface UserInterface {

    boolean updateEmployee(MyRequestDTO request, String id);
}

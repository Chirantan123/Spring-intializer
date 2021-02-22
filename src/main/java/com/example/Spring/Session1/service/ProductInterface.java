package com.example.Spring.Session1.service;

import com.example.Spring.Session1.DTO.ProductDTO;
import com.example.Spring.Session1.DTO.RequestDTO;
import com.example.Spring.Session1.DTO.ResponseDTO;

import java.util.List;

public  interface ProductInterface {
    ResponseDTO searchProducts(RequestDTO r);
}

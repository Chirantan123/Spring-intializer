package com.example.Spring.Session1.service.impl;

import com.example.Spring.Session1.DTO.ProductDTO;
import com.example.Spring.Session1.DTO.RequestDTO;
import com.example.Spring.Session1.DTO.ResponseDTO;
import com.example.Spring.Session1.service.ProductInterface;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProductService implements ProductInterface {
    public ResponseDTO searchProducts(RequestDTO r)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        ProductDTO product = new ProductDTO();
        product.setDescription("Samsung Galaxy S5.....");
        product.setTitle("samsung Galaxy S5");
        product.setSalePrice(1000);
        product.setInStock(true);
        responseDTO.setProducts(Arrays.asList(product));
        return responseDTO;
    }

}

package com.example.Spring.Session1.Controller;


import com.example.Spring.Session1.DTO.RequestDTO;
import com.example.Spring.Session1.DTO.ResponseDTO;
import com.example.Spring.Session1.service.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private ProductInterface productInterface;

    @PostMapping(value="/search")
    public ResponseDTO searchProducts(@RequestBody RequestDTO productRequestDTO)
    {
        return productInterface.searchProducts(productRequestDTO);
    }

}

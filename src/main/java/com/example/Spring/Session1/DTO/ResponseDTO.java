package com.example.Spring.Session1.DTO;

import java.util.List;

public class ResponseDTO {
    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}

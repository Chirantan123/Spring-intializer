package com.example.Spring.Session1.DTO;

import java.util.List;

public class ResponseDTO {
    private List<ProductDTO> products;
    private List<ProductDTO> locationBaseProducts;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public List<ProductDTO> getLocationBaseProducts() {
        return locationBaseProducts;
    }

    public void setLocationBaseProducts(List<ProductDTO> locationBaseProducts) {
        this.locationBaseProducts = locationBaseProducts;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}

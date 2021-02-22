package com.example.Spring.Session1.DTO;

public class ProductDTO {
    private boolean inStock;
    private Double salePrice;
    private String description;
    private String name;

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getTitle() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

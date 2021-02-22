package com.example.Spring.Session1.DTO;

public class ProductDTO {
    private boolean inStock;
    private int salePrice;
    private String description;
    private String title;

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

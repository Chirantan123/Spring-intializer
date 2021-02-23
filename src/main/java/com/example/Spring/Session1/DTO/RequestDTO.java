package com.example.Spring.Session1.DTO;

public class RequestDTO  {
    private String searchTerm;
    private String locationBaseProducts;

    public String getSearchTerm() {
        return searchTerm;
    }
    public String getLocationBaseProducts()
    {
        return locationBaseProducts;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void setLocationBaseProducts(String locationBaseProducts) {
        this.locationBaseProducts = locationBaseProducts;
    }
}

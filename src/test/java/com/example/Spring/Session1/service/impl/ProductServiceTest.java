package com.example.Spring.Session1.service.impl;

import com.example.Spring.Session1.Client.SearchClient;
import com.example.Spring.Session1.DTO.RequestDTO;
import com.example.Spring.Session1.DTO.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService searchService;

    @Mock
    private SearchClient searchClient;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> searchTermMockObject = objectMapper.readValue(new URL("file:src/test/Resources/search.mock"),Map.class);
        Map<String,Object> locationMockObject = objectMapper.readValue(new URL("file:src/test/Resources/location.mock"),Map.class);
        Mockito.when(searchClient.getProducts("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:\"Jakarta\"")).thenReturn(locationMockObject);
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setLocationBaseProducts("Jakarta");
        ResponseDTO response = searchService.searchProducts(requestDTO);
        assertEquals(response.getProducts().size(),10);
        assertEquals(response.getLocationBaseProducts().size(),10);
    }
}
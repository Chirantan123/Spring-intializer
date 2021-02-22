package com.example.Spring.Session1.service.impl;

import com.example.Spring.Session1.Client.SearchClient;
import com.example.Spring.Session1.DTO.ProductDTO;
import com.example.Spring.Session1.DTO.RequestDTO;
import com.example.Spring.Session1.DTO.ResponseDTO;
import com.example.Spring.Session1.service.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements ProductInterface {

    @Autowired
    private SearchClient searchClient;
    @Override
    public ResponseDTO searchProducts(RequestDTO r)
    {
        Map<String, Object> productResponse = searchClient.getProducts(r.getSearchTerm());
        List<Map<String, Object>> products = (List<Map<String, Object>>) ((Map<String, Object>) productResponse.get("response")).get("docs");
        ArrayList<ProductDTO> a = new ArrayList<>();
        for (Map<String, Object> product: products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setDescription((String) product.get("description"));
            productDTO.setTitle((String)product.get("name"));
            int c=(int)product.get("isInStock");
            if(c==1)
            productDTO.setInStock(true);
            else
            productDTO.setInStock(false);
            productDTO.setSalePrice((Double)product.get("salePrice"));
            ;
            // create list of ProductDTO and add there
            a.add(productDTO);
        }
        ResponseDTO responseDTO = new ResponseDTO();

        // setter your list products
        responseDTO.setProducts(a);
        return responseDTO;
    }

}

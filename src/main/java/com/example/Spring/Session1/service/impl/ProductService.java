package com.example.Spring.Session1.service.impl;

import com.example.Spring.Session1.Client.SearchClient;
import com.example.Spring.Session1.DTO.ProductDTO;
import com.example.Spring.Session1.DTO.RequestDTO;
import com.example.Spring.Session1.DTO.ResponseDTO;
import com.example.Spring.Session1.service.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Service
public class ProductService implements ProductInterface {

    @Autowired
    private SearchClient searchClient;
    private ArrayList<ProductDTO> getSearchResponse(RequestDTO r)
    {
        System.out.println("Inside thread SearchTerm");
        Map<String,Object> productResponse = searchClient.getProducts(r.getSearchTerm());
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
        return a;
    }
    private ArrayList<ProductDTO> getLocationResponse(RequestDTO r)
    {
        System.out.println("Inside thread location");
        Map<String,Object>  productResponse1 = searchClient.getProducts("stockLocation:\""+r.getLocationBaseProducts()+"\"");
        List<Map<String, Object>> products1 = (List<Map<String, Object>>) ((Map<String, Object>) productResponse1.get("response")).get("docs");
        ArrayList<ProductDTO> a1 = new ArrayList<>();
        for(Map<String,Object> product:products1)
        {
            ProductDTO productDTO1 = new ProductDTO();
            productDTO1.setDescription((String)product.get("description"));
            productDTO1.setTitle((String)product.get("name"));
            int c = (int)product.get("isInStock");
            if(c==1)
                productDTO1.setInStock(true);
            else
                productDTO1.setInStock(false);
            a1.add(productDTO1);
        }
        return a1;
    }


    @Override
    public ResponseDTO searchProducts(RequestDTO r) {
        ResponseDTO responseDTO = new ResponseDTO();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ArrayList<ProductDTO> a1;
        Runnable runnableTask = () -> {
            //try {
              //  Thread.sleep(1000);
            //} catch (InterruptedException e) {
              //  e.printStackTrace();
            //}
            System.out.println(Thread.currentThread().getName());
                responseDTO.setProducts(getSearchResponse(r));
        };
        executor.execute(runnableTask);
        // await termination, shutdown
        //executor.shutdown();

        Runnable runnableTask1 = () -> {
            System.out.println(Thread.currentThread().getName());
                responseDTO.setLocationBaseProducts(getLocationResponse(r));
        };
        executor.execute(runnableTask1);
        // await termination, shutdown
        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        return responseDTO;
    }


   /* @Override
    public ResponseDTO searchProducts(RequestDTO r)
    {
        Map<String, Object> productResponse = searchClient.getProducts(r.getSearchTerm());
        Map<String,Object>  productResponse1 = searchClient.getProducts("stockLocation:\""+r.getLocationBaseProducts()+"\"");
        List<Map<String, Object>> products = (List<Map<String, Object>>) ((Map<String, Object>) productResponse.get("response")).get("docs");
        List<Map<String, Object>> products1 = (List<Map<String, Object>>) ((Map<String, Object>) productResponse1.get("response")).get("docs");
        ArrayList<ProductDTO> a = new ArrayList<>();
        ArrayList<ProductDTO> a1 = new ArrayList<>();
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
        for(Map<String,Object> product:products1)
        {
            ProductDTO productDTO1 = new ProductDTO();
            productDTO1.setDescription((String)product.get("description"));
            productDTO1.setTitle((String)product.get("name"));
            int c = (int)product.get("isInStock");
            if(c==1)
            productDTO1.setInStock(true);
            else
            productDTO1.setInStock(false);
            a1.add(productDTO1);
        }
        ResponseDTO responseDTO = new ResponseDTO();

        // setter your list products
        responseDTO.setProducts(a);
        responseDTO.setLocationBaseProducts(a1);
        return responseDTO;
    }*/


}


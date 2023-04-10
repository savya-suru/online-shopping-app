package com.example.online.shopping.service;

import com.example.online.shopping.exception.NoProductExists;
import com.example.online.shopping.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct() throws NoProductExists, NoProductExists;

    List<Product> searchByProductName(String name);

    Product addProduct(Product product);

    String productStatus(String id);

    String deleteProduct(String id);
}

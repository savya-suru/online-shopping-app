package com.example.online.shopping.controller;

import com.example.online.shopping.exception.NoProductExists;
import com.example.online.shopping.model.Product;
import com.example.online.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/shopping")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() throws NoProductExists {
        return productService.getAllProduct();
    }

    @GetMapping("/products/search/{productName}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public List<Product> getProductByName(@PathVariable String productName){
        System.out.println("Search by Product Name is working "+productName);
        return productService.searchByProductName(productName);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Product addNewProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public String updateProductStatus(@PathVariable String id){
        return productService.productStatus(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id){
        System.out.println("Delete id = "+id);
        return productService.deleteProduct(id);
    }
}

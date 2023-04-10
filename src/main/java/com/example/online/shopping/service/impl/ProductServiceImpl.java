package com.example.online.shopping.service.impl;

import com.example.online.shopping.exception.NoProductExists;
import com.example.online.shopping.exception.ProductNotFound;
import com.example.online.shopping.model.Product;
import com.example.online.shopping.repository.ProductRepository;
import com.example.online.shopping.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() throws NoProductExists {
        log.info("Get all product method working correctly");
        List<Product> products = productRepository.findAll();
        if(products.size() == 0){
            log.warn("No product is available");
            throw new ProductNotFound("There is no product available");
        }
        log.info("All products = "+products);
        return products;
    }

    @Override
    public List<Product> searchByProductName(String name) {
//        List<Product> products = (List<Product>) productRepository.findByProductName(name);

        List<Product> products = (List<Product>) productRepository.findByRegex("^"+name);
        if(products.size() == 0) {
            log.warn("No product available with this name");
            throw new ProductNotFound("No Product with this name is available");
        }

        log.info("All product with name starting "+name+" is "+products);
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        log.info("Adding the product "+product);
        productRepository.save(product);
        return product;
    }

    @Override
    public String productStatus(String id) throws ProductNotFound {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFound("Product Not found"));


        int quantityZero = 0;
        log.info("Updating the product status of product"+product+" with id "+id);
        if(quantityZero == 0)
            product.setProductStatus("Out of Stock");

        productRepository.save(product);

        return "Product Status Updated Successfull";
    }

    @Override
    public String deleteProduct(String id) {
//        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFound("Username not found"));
        boolean f = productRepository.existsById(id);
        if(!f){
            log.warn("Product can not be deleted which are not present");
            throw new ProductNotFound("Product is not available which you want to delete");
        }
        productRepository.deleteById(id);
        log.warn("Deleted product successfully");
        return "Deleted Successfuly";
    }
}
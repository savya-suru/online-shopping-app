package com.example.online.shopping.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {

    private String id;
    private String productName;
    private String productDescription;
    private double price;
    private String feature;
    private String productStatus;
    private String imgUrl;
    private double rating;
}
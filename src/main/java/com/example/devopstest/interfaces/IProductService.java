package com.example.devopstest.interfaces;

import com.example.devopstest.entities.Product;

import java.util.List;

public interface IProductService
{
    List<Product> retrieveAllProducts();

    Product addProduct(Product product);

    void deleteProduct(Long id);

    Product updateProduct(Product product);

    Product retrieveProduct(Long id);

    void assignProductToStock(Long productId, Long stockId);
}

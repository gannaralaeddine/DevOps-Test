package com.example.devopstest;

import com.example.devopstest.entities.Product;

import com.example.devopstest.interfaces.IProductService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest
{

    @Autowired
    IProductService productService;


    @Test
    @Order(1)
    void testRetrieveAllProducts()
    {
        List<Product> products = productService.retrieveAllProducts();
        Assertions.assertEquals(0, products.size());
    }


}

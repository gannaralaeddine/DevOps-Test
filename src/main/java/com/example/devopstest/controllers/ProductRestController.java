package com.example.devopstest.controllers;

import com.example.devopstest.entities.Product;
import com.example.devopstest.interfaces.IProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "GProducts Management")
@RequestMapping("/product")
public class ProductRestController
{
    @Autowired
    IProductService productService;

    @GetMapping("/retrieve-all-products")
    @ResponseBody
    public List<Product> getProducts() {
        return productService.retrieveAllProducts();
    }

    @GetMapping("/retrieve-product/{product-id}")
    @ResponseBody
    public Product retrieveRayon(@PathVariable("product-id") Long productId) {
        return productService.retrieveProduct(productId);
    }


    @PostMapping("/add-Product")
    @ResponseBody
    public Product addProduct(@RequestBody Product p) {
        return productService.addProduct(p);
    }

    @DeleteMapping("/remove-Product/{product-id}")
    @ResponseBody
    public void removeProduct(@PathVariable("product-id") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/modify-Product")
    @ResponseBody
    public Product modifyProduct(@RequestBody Product p) {
        return productService.updateProduct(p);
    }


    @PutMapping(value = "/assignProductToStock/{idProduct}/{idStock}")
    public void assignProductToStock(@PathVariable("idProduct") Long idProduct, @PathVariable("idStock") Long idStock) {
        productService.assignProductToStock(idProduct, idStock);
    }
}

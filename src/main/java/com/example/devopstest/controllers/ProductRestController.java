package com.example.devopstest.controllers;

import com.example.devopstest.entities.Product;
import com.example.devopstest.interfaces.IProductService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "Products Management")
@RequestMapping("/product")
//@CrossOrigin( origins = "http://localhost:4200")
@CrossOrigin( origins = "*")
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
    public Product retrieveProduct(@PathVariable("product-id") Long productId) {
        return productService.retrieveProduct(productId);
    }


    @PostMapping(value = "/add-product")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {

        Product persistentProduct = new Product();
        persistentProduct.setProductCode(product.getProductCode());
        persistentProduct.setProductDescription(product.getProductDescription());
        persistentProduct.setProductPrice(product.getProductPrice());
        return productService.addProduct(persistentProduct);
    }

    @DeleteMapping("/delete-product/{product-id}")
    @ResponseBody
    public void deleteProduct(@PathVariable("product-id") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/update-product")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }


    @PutMapping(value = "/assignProductToStock/{idProduct}/{idStock}")
    public void assignProductToStock(@PathVariable("idProduct") Long idProduct, @PathVariable("idStock") Long idStock) {
        productService.assignProductToStock(idProduct, idStock);
    }
}

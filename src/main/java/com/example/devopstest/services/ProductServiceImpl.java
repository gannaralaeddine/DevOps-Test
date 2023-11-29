package com.example.devopstest.services;

import com.example.devopstest.entities.Product;
import com.example.devopstest.entities.Stock;
import com.example.devopstest.interfaces.IProductService;
import com.example.devopstest.repositories.ProductRepository;
import com.example.devopstest.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long productId, Product product)
    {
        Product existingProduct = productRepository.findById(productId).orElse(null);

        if (existingProduct != null)
        {
            existingProduct.setProductCode(product.getProductCode());
            existingProduct.setProductDescription(product.getProductDescription());
            existingProduct.setProductPrice(product.getProductPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public Product retrieveProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProductToStock(Long productId, Long stockId) {
        Product product = productRepository.findById(productId).orElse(null);
        Stock stock = stockRepository.findById(stockId).orElse(null);
        assert product != null;
        product.setStock(stock);
        productRepository.save(product);
    }
}

package com.example.devopstest.services;

import com.example.devopstest.entities.Stock;
import com.example.devopstest.interfaces.IStockService;
import com.example.devopstest.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService
{

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Stock updateStock(Long stockId, Stock stock) {

        Stock existingStock = stockRepository.findById(stockId).orElse(null);

        if (existingStock != null)
        {
            existingStock.setLibelleStock(stock.getLibelleStock());
            existingStock.setQte(stock.getQte());
            existingStock.setQteMin(stock.getQteMin());
            return stockRepository.save(existingStock);
        }
        return null;
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }
}

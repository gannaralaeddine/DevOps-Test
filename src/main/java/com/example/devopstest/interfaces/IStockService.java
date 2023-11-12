package com.example.devopstest.interfaces;

import com.example.devopstest.entities.Stock;

import java.util.List;

public interface IStockService
{
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock stock);

    void deleteStock(Long id);

    Stock updateStock(Stock stock);

    Stock retrieveStock(Long id);
}

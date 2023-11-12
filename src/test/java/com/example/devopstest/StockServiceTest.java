package com.example.devopstest;

import com.example.devopstest.entities.Stock;
import com.example.devopstest.interfaces.IStockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTest
{
    @Autowired
    IStockService stockService;

    @Test
    public void testAddStock()
    {
        List<Stock> stocks = stockService.retrieveAllStocks();
        Stock savedStock= stockService.addStock( new Stock("stock test",50,25) );
        assertEquals(stocks.size()+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());
    }

    @Test
    public void testAddStockOptimized() {

        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);
        assertNotNull(savedStock.getIdStock());
        assertSame(10, savedStock.getQte());
        assertTrue(savedStock.getQteMin()>0);
        stockService.deleteStock(savedStock.getIdStock());

    }

    @Test
    public void testDeleteStock() {
        Stock s = new Stock("stock test",30,60);
        Stock savedStock= stockService.addStock(s);
        stockService.deleteStock(savedStock.getIdStock());
        assertNull(stockService.retrieveStock(savedStock.getIdStock()));
    }
}

package com.example.devopstest;

import com.example.devopstest.entities.Stock;
import com.example.devopstest.repositories.StockRepository;
import com.example.devopstest.services.StockServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class StockMockTest
{
    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockService;

    Stock s1 = new Stock("stock0", 1,2);
    Stock f2 = new Stock("Code 2",12,20);

    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(s1);
            add(new Stock("stock0", 1,2));
            add(new Stock("Code 2",12,20));
        }
    };

    @Test
    public void retrieveStocks() {
        System.out.println("retrieveStocks");
        Mockito.when(stockRepository.findById(12L)).thenReturn(Optional.of(s1));
        Stock stock1 = stockService.retrieveStock(12L);
        assertNotNull(stock1);
    }

    @Test
    public void testRetrieveAllStock() {
        System.out.println("retrieveAllStocks");
        Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
        List<Stock> stockList3 = stockService.retrieveAllStocks();
        assertEquals(3, stockList3.size());
        //assertEquals(stock1.,55L);
    }

    @Test
    public void testAddStock(){
        System.out.println("test add Stock");
        Mockito.when(stockRepository.save(s1)).thenReturn(s1);
        Stock stock1 = stockService.addStock(s1);
        assertNotNull(stock1);
        Mockito.verify(stockRepository, times(1)).save(Mockito.any(Stock.class));
    }


    @Test
    public void testDeleteStock(){
        System.out.println("test delete Stock");
        stockService.deleteStock(66L);
        Mockito.verify(stockRepository, times(0)).delete(f2);
    }
}

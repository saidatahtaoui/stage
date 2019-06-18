package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Stock;
import com.spring.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	StockRepository stockRepository;
	
	public List<Stock> getAllStocks(){
		List<Stock> stockList = new ArrayList<>();
		stockRepository.findAll().forEach(stockList::add);
		return stockList;
	}
	
	public List<Stock> getStockById(int idStock){
		
		List<Stock> stockList = new ArrayList<>();
		stockList.add(stockRepository.findById(idStock).get());
		return stockList;
	}

	public String saveStock(Stock stock) {
		
		Stock savedStock = stockRepository.save(stock);
		if(savedStock!=null) {
			return "Saved : stock = "+ savedStock.getIdStock();
		}
		else {
			return "Failed : stock = "+ stock.getIdStock();

		}
		
	}

	public String deleteStock(Stock stock) {
		// TODO Auto-generated method stub
		stockRepository.delete(stock);
		return "Deleted";
	}

	public String deleteStockById(int stockId) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(stockId);
		return "Deleted";
	}
	
}

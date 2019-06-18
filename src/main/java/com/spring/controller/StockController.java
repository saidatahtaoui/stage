package com.spring.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Stock;
import com.spring.repository.StockRepository;
import com.spring.service.StockService;

@RestController
@RequestMapping(path="/stock")
public class StockController {
	@Autowired 
	StockService stockService;
	@Autowired
	private StockRepository cIRepository;
	@GetMapping(path="/getAllStocks")
	public List<Stock> getAllStocks(){
		List<Stock> stockList = new ArrayList<>();
		stockList.addAll(stockService.getAllStocks());
		return stockList;
	}
	@GetMapping("/getStockById/{stockId}")	
	public List<Stock> getStockByNom(@PathVariable(name="stockId")int idStock)	
	{	
	List<Stock> stockList = new ArrayList<>();
	stockList.addAll(stockService.getStockById(idStock));
	return stockList;
	}
	@PostMapping("/saveStock")
	public String saveStock (@RequestBody Stock stock)
	{
		return stockService.saveStock(stock);
	}
	@DeleteMapping(path="/deleteStock")
	public String deleteStock(@RequestBody Stock stock ) {
		return stockService.deleteStock(stock);
	}
	@DeleteMapping(path="/deleteStockId/{stockId}")
	public String deleteStockById(@PathVariable(name="stockId")int stockId) {
		return stockService.deleteStockById(stockId);
	}
	@PutMapping("/updatesociete/{id}")
	public ResponseEntity<Object> updateStock(@RequestBody Stock couleurE, @PathVariable int id) {

		java.util.Optional<Stock> cEOptional = cIRepository.findById(id);

		if (!cEOptional.isPresent())
			return ResponseEntity.notFound().build();

		couleurE.setIdStock(id);
		
		cIRepository.save(couleurE);

		return ResponseEntity.noContent().build();
	}
}

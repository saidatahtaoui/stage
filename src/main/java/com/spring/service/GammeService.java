package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Gamme;
import com.spring.repository.GammeRepository;

@Service
public class GammeService {
	@Autowired
	GammeRepository gammeRepository;
	public List<Gamme> getAllGammes() {
		// TODO Auto-generated method stub
		List<Gamme> gammeList = new ArrayList<>();
		gammeRepository.findAll().forEach(gammeList::add);
		return gammeList;
	}
	public List<Gamme> getGammeById(int idGamme) {
		// TODO Auto-generated method stub
		List<Gamme> gammeList= new ArrayList<>();
		gammeList.add(gammeRepository.findById(idGamme).get());
		return gammeList;
	}
	public Gamme saveGamme(Gamme gamme) {
		// TODO Auto-generated method stub
		return this.gammeRepository.save(gamme);

	}
	public String deleteGamme(Gamme gamme) {
		// TODO Auto-generated method stub
		gammeRepository.delete(gamme);
		return "Deleted";
	}
	public String deleteGammeById(int gammeId) {
		// TODO Auto-generated method stub
		gammeRepository.deleteById(gammeId);
		return "Deleted";
	}

}

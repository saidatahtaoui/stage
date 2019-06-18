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

import com.spring.model.Site;
import com.spring.repository.SiteRepository;
import com.spring.service.SiteService;

@RestController
@RequestMapping(path="/site")
public class SiteController {

	@Autowired
	SiteService siteService;
	@Autowired
	private SiteRepository cIRepository;
	@GetMapping(path="/getAllSites")
	public List<Site> getAllSites(){
		List<Site> siteList = new ArrayList<>();
		siteList.addAll(siteService.getAllSites());
		return siteList;

	}
	@GetMapping(path="/getSiteById/{siteId}")	
	public List<Site> getSiteById(@PathVariable(name="siteId")int idSite)	
	{	
	List<Site> siteList = new ArrayList<>();
	siteList.addAll(siteService.getSiteById(idSite));
	return siteList;
	}
	@PostMapping(path="/saveSite")
	public String saveSite (@RequestBody Site site)
	{
		return siteService.saveSite(site);
	}
	@DeleteMapping(path="/deleteSite")
	public String deleteSite(@RequestBody Site site) {
		return siteService.deleteSite(site);
	}
	@DeleteMapping(path="/deleteSiteById/{siteId}")
	public String deleteSiteById(@PathVariable(name="siteId")int siteId) {
		return siteService.deleteSiteById(siteId);
	}
	@PutMapping("/updatesite/{id}")
	public ResponseEntity<Object> updateSite(@RequestBody Site couleurE, @PathVariable int id) {

		java.util.Optional<Site> cEOptional = cIRepository.findById(id);

		if (!cEOptional.isPresent())
			return ResponseEntity.notFound().build();

		couleurE.setIdSite(id);
		
		cIRepository.save(couleurE);

		return ResponseEntity.noContent().build();
	}
	 

}

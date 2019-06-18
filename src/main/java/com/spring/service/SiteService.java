package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Site;
import com.spring.repository.SiteRepository;

@Service
public class SiteService {
	
	@Autowired
	SiteRepository siteRepository;
	public List<Site> getAllSites() {
		// TODO Auto-generated method stub
		List<Site> siteList = new ArrayList<>();
		siteRepository.findAll().forEach(siteList::add);
		return siteList;
	}
	public List<Site> getSiteById(int idSite) {
		// TODO Auto-generated method stub
		List<Site> siteList= new ArrayList<>();
		siteList.add(siteRepository.findById(idSite).get());
		return siteList;
	}
	public String saveSite(Site site) {
		// TODO Auto-generated method stub
		Site savedSite=siteRepository.save(site);
		if(savedSite!=null) {
			return "Saved : site = "+ savedSite.getIdSite();
		}
		else {
			return "Failed : site = "+ site.getIdSite();

		}
	}
	public String deleteSite(Site site) {
		// TODO Auto-generated method stub
		siteRepository.delete(site);
		return "Deleted";
	}
	public String deleteSiteById(int siteId) {
		// TODO Auto-generated method stub
		siteRepository.deleteById(siteId);
		return "Deleted";
	}

	
	

}

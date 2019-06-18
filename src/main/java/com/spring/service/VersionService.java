package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Version;
import com.spring.repository.VersionRepository;

@Service
public class VersionService {

	@Autowired
	VersionRepository versionRepository;
	
	public List<Version> getAllVersions(){
		List<Version> versionList = new ArrayList<>();
		versionRepository.findAll().forEach(versionList::add);
		return versionList;
	}
	
	public List<Version> getVersionById(int idVersion){
		
		List<Version> versionList = new ArrayList<>();
		versionList.add(versionRepository.findById(idVersion).get());
		return versionList;
	}

	public Version saveVersion(Version version) {
		
		return this.versionRepository.save(version);

		
	}

	public String deleteVersion(Version version) {
		// TODO Auto-generated method stub
		versionRepository.delete(version);
		return "Deleted";
	}

	public String deleteVersionById(int versionId) {
		// TODO Auto-generated method stub
		versionRepository.deleteById(versionId);
		return "Deleted";
	}

	
	

}

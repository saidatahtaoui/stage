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

import com.spring.dto.ApiResponse;
import com.spring.model.Version;
import com.spring.repository.VersionRepository;
import com.spring.service.VersionService;

@RestController
@RequestMapping(path="/version")
public class VersionController {
	@Autowired
	VersionService versionService;
	@Autowired
	private VersionRepository versionRepository;
	@GetMapping(path="/getAllVersions")
	public List<Version> getAllVersions(){
		List<Version> versionList = new ArrayList<>();
		versionList.addAll(versionService.getAllVersions());
		return versionList;

    }
	@GetMapping(path="/getVersionById/{versionId}")	
	public List<Version> getSVersionById(@PathVariable(name="versionId")int idVersion)	
	{	
	List<Version> versionList = new ArrayList<>();
	versionList.addAll(versionService.getVersionById(idVersion));
	return versionList;
	}
	@PostMapping("/saveVersion")
	public ResponseEntity<ApiResponse>  saveVersion (@RequestBody Version version)
	
	{
			Version result = this.versionService.saveVersion(new Version(version.getIdVersion(),version.getNomVersion(),version.getModels()));
			int result1 = result.getIdVersion();
			String result3=result.getNomVersion();
			String vVersion=result1+result3;
			version.setvVersion(vVersion);		
				//clientService.deleteClientById(result1);
			Version result4 = this.versionService.saveVersion(new Version(version.getIdVersion(),version.getNomVersion(),version.getModels(),version.getvVersion()));



			if (result4 != null)
				return ResponseEntity.ok(new ApiResponse(true, "Version registered successfully"));
			else
				return ResponseEntity.ok(new ApiResponse(false, "Error Versionis not registered"));
		}

	@DeleteMapping(path="/deleteVersion")
	public String deleteVersion(@RequestBody Version version ) {
		return versionService.deleteVersion(version);
	}
	@DeleteMapping(path="/deleteVersionId/{versionId}")
	public String deleteVersionById(@PathVariable(name="versionId")int versionId) {
		return versionService.deleteVersionById(versionId);
	}
	@PutMapping("/updateversion/{id}")
	public ResponseEntity<Object> updateVersion(@RequestBody Version version, @PathVariable int id) {

		java.util.Optional<Version> cEOptional = versionRepository.findById(id);

		if (!cEOptional.isPresent())
			return ResponseEntity.notFound().build();
		int result1 = version.getIdVersion();
		String result3=version.getNomVersion();
		String vVersion=result1+result3;
		version.setvVersion(vVersion);
		Version result4 = this.versionService.saveVersion(new Version(version.getIdVersion(),version.getNomVersion(),version.getModels(),version.getvVersion()));

		if (result4 != null)
			return ResponseEntity.ok(new ApiResponse(true, "Version registered successfully"));
		else
			return ResponseEntity.ok(new ApiResponse(false, "Error Version is not registered"));	}

}

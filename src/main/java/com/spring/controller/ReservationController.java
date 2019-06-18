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
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Reservation;
import com.spring.repository.ReservationRepository;
import com.spring.service.ReservationService;


@RestController
public class ReservationController {


	@Autowired
	ReservationService resService;
	@Autowired
	private ReservationRepository cIRepository;
	@GetMapping(path="/getAllRes")
	public List<Reservation> getAllReservation(){
		List<Reservation> resList = new ArrayList<>();
		resList.addAll(resService.getAllReservations());
		return resList;

	}
	@GetMapping(path="/getReservationById/{resId}")	
	public List<Reservation> getResById(@PathVariable(name="resId")int idRes)	
	{	
	List<Reservation> resList = new ArrayList<>();
	resList.addAll(resService.getReservationById(idRes));
	return resList;
	}
	@PostMapping(path="/saveRes")
	public String saveRes (Reservation res)
	{
		return resService.saveRes(res);
	}
	@DeleteMapping(path="/deleteRes")
	public String deleteRes(@RequestBody Reservation res ){
		return resService.deleteRes(res);
	}
	@DeleteMapping(path="/deleteResId/{resId}")
	public String deleteResById(@PathVariable(name="resId")int resId) {
		return resService.deleteResById(resId);
	}
	@PutMapping("/updatereservation/{id}")
	public ResponseEntity<Object> updateReservation(@RequestBody Reservation couleurE, @PathVariable int id) {

		java.util.Optional<Reservation> cEOptional = cIRepository.findById(id);

		if (!cEOptional.isPresent())
			return ResponseEntity.notFound().build();

		couleurE.setIdReservation(id);
		
		cIRepository.save(couleurE);

		return ResponseEntity.noContent().build();
	}
}

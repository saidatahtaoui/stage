package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Reservation;
import com.spring.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository resRepository;
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		List<Reservation> resList = new ArrayList<>();
		resRepository.findAll().forEach(resList::add);
		return resList;
	}
	public List<Reservation> getReservationById(int idRes) {
		// TODO Auto-generated method stub
		List<Reservation> resList= new ArrayList<>();
		resList.add(resRepository.findById(idRes).get());
		return resList;
	}
	public String saveRes(Reservation res) {
		// TODO Auto-generated method stub
		Reservation savedRes=resRepository.save(res);
		if(savedRes!=null) {
			return "Saved : reservation = "+ savedRes.getIdReservation();
		}
		else {
			return "Failed : reservation = "+ res.getIdReservation();

		}
	}
	public String deleteRes(Reservation res) {
		// TODO Auto-generated method stub
		resRepository.delete(res);
		return "Deleted";
	}
	public String deleteResById(int resId) {
		// TODO Auto-generated method stub
		resRepository.deleteById(resId);
		return "Deleted";
	}

}

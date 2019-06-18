package com.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{

}

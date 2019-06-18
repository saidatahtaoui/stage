package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Client;


@Repository
public interface  ClientRepository extends CrudRepository<Client, Integer> {
	
	@Query(value="SELECT SUM(id_vente) AS totalVenteSite,c.genre   FROM vente v, client c WHERE v.id_client=c.id_client GROUP BY c.genre", nativeQuery = true)
	List<Object[]> totalVenteGenre();
	
	
	
    		
	
}

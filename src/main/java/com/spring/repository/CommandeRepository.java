package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.model.Commande;

public interface CommandeRepository extends CrudRepository<Commande, Integer>{
	@Query(value="	SELECT  MIN(delai_livraison),m.v_model,f.id_fournisseur FROM commande c,fournisseur f ,model m WHERE m.v_model=m.v_model AND c.id_fournisseur=f.id_fournisseur GROUP BY m.v_model,f.id_fournisseur",nativeQuery = true)
	List<Object[]> resultFournisseur();

}

package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.model.Vente;

public interface VenteRepository extends CrudRepository<Vente, Integer>{
	
	@Query(value="SELECT SUM(id_vente) as totalVente,vs.id_version  FROM vente v, version vs WHERE v.id_version=vs.id_version GROUP BY vs.id_version", nativeQuery = true)
	int globalVenteVersion();
	
	@Query(value="SELECT SUM(id_vente) as totalVenteE,vs.id_version, ce.id_couleur_exterieur,m.id_marque FROM vente v,couleur_exterieur ce, version vs, marque m WHERE ce.id_couleur_exterieur=v.id_couleur_exterieur AND vs.id_version=v.id_vente AND m.id_marque=v.id_marque GROUP BY ce.id_couleur_exterieur,vs.id_version,m.id_marque",nativeQuery = true)
	List<Object[]> resultVenteByColorE();
	
	@Query(value="SELECT  SUM(id_vente) as totalVenteI ,vs.id_version, ci.id_couleur_interieur,m.id_marque FROM vente v,version vs,couleur_interieur ci, marque m WHERE ci.id_couleur_interieur=v.id_couleur_interieur AND vs.id_version=v.id_vente AND m.id_marque=v.id_marque GROUP BY ci.id_couleur_interieur,vs.id_version, m.id_marque",nativeQuery = true)
	List<Object[]> resultVenteByColorI();
	
	@Query(value="SELECT  SUM(id_vente) as totalVenteI ,vs.id_version, ci.id_couleur_interieur,m.id_marque, ce.id_couleur_exterieur FROM vente v,version vs,couleur_interieur ci, marque m WHERE ci.id_couleur_interieur=v.id_couleur_interieur AND vs.id_version=v.id_vente AND m.id_marque=v.id_marque AND ce.id_couleur_exterieur=v.id_couleur_exterieur GROUP BY ci.id_couleur_interieur,vs.id_version, m.id_marque,ce.id_couleur_exterieur",nativeQuery = true)
	List<Object[]> resultVente();
	
	@Query(value=" SELECT  SUM(id_vente) as totalVenteI ,vs.id_version, s.nom_site,ci.id_couleur_interieur,m.id_marque, ce.id_couleur_exterieur FROM vente v,version vs,couleur_interieur ci, marque m, site s, couleur_exterieur ce WHERE ci.id_couleur_interieur=v.id_couleur_interieur AND vs.id_version=v.id_vente AND m.id_marque=v.id_marque AND ce.id_couleur_exterieur=v.id_couleur_exterieur AND s.id_site=v.id_site GROUP BY ci.id_couleur_interieur,vs.id_version, m.id_marque,ce.id_couleur_exterieur,s.nom_site",nativeQuery = true)
	List<Object[]> resultVenteBySite();
	
	@Query(value=" SELECT  SUM(id_vente) as totalVenteI ,vs.id_version, s.nom_site,s.ville_site,ci.id_couleur_interieur,m.id_marque, ce.id_couleur_exterieur FROM vente v,version vs,couleur_interieur ci, marque m, site s, couleur_exterieur ce WHERE ci.id_couleur_interieur=v.id_couleur_interieur AND vs.id_version=v.id_vente AND m.id_marque=v.id_marque AND ce.id_couleur_exterieur=v.id_couleur_exterieur AND s.id_site=v.id_site GROUP BY ci.id_couleur_interieur,vs.id_version, m.id_marque,ce.id_couleur_exterieur,s.nom_site,s.ville_site",nativeQuery = true)
	List<Object[]> resultVenteByVille();
	


	
}
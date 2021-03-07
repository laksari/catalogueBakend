package org.sid.catservice.dao;

import java.util.List;

import org.sid.catservice.model.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	
	@RestResource(path = "/prdByDesignation")
	public List<Produit> findByDesignationContains(@Param("prd") String desig);
	
	
	@RestResource(path = "/prdByDesignationPage")
	public Page<Produit> findByDesignationContains(@Param("prd") String desig, Pageable pageabe);
	
	@RestResource(path = "/chercherLst")
	@Query("Select p from Produit p")
	public Page<Produit> findAll1(Pageable pageabe);
	
 
}

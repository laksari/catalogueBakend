package org.sid.catservice.controller;

import java.util.List;

import org.sid.catservice.dao.ProduitRepository;
import org.sid.catservice.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class ProduitRestController {

	@Autowired
	ProduitRepository produitDao;
	//ttt55556666
	
	@GetMapping("/listeProduits")
	public Page<Produit> listeProduit(Pageable pageable){
		
		List<Produit> produits = produitDao.findAll();
		
		return new PageImpl<Produit>(produits, pageable, produits.size());
	}
	
	
	@GetMapping("/listeProduits/{id}")
	public Produit getProduit(@Param("id") Long id){
		
		return produitDao.findById(id).get();
	}
	
	
	@PutMapping("/updateProduit/{id}")
	public Produit updateProduit(@PathVariable("id") Long id, @RequestBody Produit produit){
		
		produit.setId(id);
		return produitDao.save(produit);
	}
	
	
	@PostMapping("/newProduit")
	public Produit newProduit( @RequestBody Produit produit){
		
		return produitDao.save(produit);
	}
	
	
	@DeleteMapping ("/listeProduits/{id}")
	public void deleteProduit( @PathVariable("id") Long id){
		System.out.println("-------------------------   "+id);
		
		 produitDao.deleteById(id);
	}
	
	
}

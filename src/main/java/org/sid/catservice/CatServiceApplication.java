package org.sid.catservice;

import java.util.List;
import java.util.function.Consumer;

import org.sid.catservice.dao.ProduitRepository;
import org.sid.catservice.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;
	//test 
	//toto
	
	@Autowired
	RepositoryRestConfiguration restConfig;
	//test66

	public static void main(String[] args) {
		//test
		SpringApplication.run(CatServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Exposer l'id de l'objet
		restConfig.exposeIdsFor(Produit.class);

		/*produitRepository.save(new Produit(null, "ordinateur HP", 400.00, 20));
		produitRepository.save(new Produit(null, "ordinateur samsung", 300.00, 10));
		produitRepository.save(new Produit(null, "ordinateur ACER", 450.00, 20));
		produitRepository.save(new Produit(null, "ordinateur MSI", 800.00, 20));
		produitRepository.save(new Produit(null, "ordinateur DELL", 450.00, 10));
		produitRepository.save(new Produit(null, "VTT", 500.00, 20));
		produitRepository.save(new Produit(null, "Velo electrique", 1000.00, 10));
		produitRepository.save(new Produit(null, "Velo femme", 300.00, 30));
		produitRepository.save(new Produit(null, "Velo enfant fille", 120.00, 20));
		produitRepository.save(new Produit(null, "Velo enfant garcon", 100.00, 20));
		produitRepository.save(new Produit(null, "casque velo adulte", 30.00, 30));
		produitRepository.save(new Produit(null, "casque velo enfant", 20.00, 15));
		produitRepository.save(new Produit(null, "Disque dur externe", 12.00,15));
		produitRepository.save(new Produit(null, "cle usb", 15.00, 100));
		produitRepository.save(new Produit(null, "Appareil photo", 80.00, 25));
		produitRepository.save(new Produit(null, "Home cinema",330.00, 10));
		produitRepository.save(new Produit(null, "Disque dur interne", 60.00, 10));*/

		List<Produit> lstProduit = produitRepository.findAll();

		lstProduit.stream().forEach((p) -> System.out.println(p));
		//test77777

	}

}

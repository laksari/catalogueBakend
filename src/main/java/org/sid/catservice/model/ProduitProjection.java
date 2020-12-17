package org.sid.catservice.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1", types = Produit.class)
public interface ProduitProjection {
	
	public Double getPrice();

}

package com.unla.PedidosYaGrupoF.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unla.PedidosYaGrupoF.entities.Product;


@Repository("productRepository")
public interface IProductRepository extends JpaRepository<Product, Serializable> {

	public abstract Product findByIdProduct(long idProduct);
	
	// Todas los productos que tengan una descripcion con ese nombre (parámetro nombre)
		@Query("SELECT p FROM  Product p WHERE p.name = (:name)")
		public abstract List<Product> findByName(String name);
	
	// Todas los productos que tengan una descripcion con ese nombre (parámetro descripcion)
	@Query("SELECT p FROM  Product p WHERE p.description = (:description)")
	public abstract List<Product> findByDescriptionName(String description);
	
	
	
	
	
}
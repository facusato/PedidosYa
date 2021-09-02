package com.unla.PedidosYaGrupoF.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.unla.PedidosYaGrupoF.entities.Delivery;

@Repository("deliveryRepository")
public interface IDeliveryRepository extends JpaRepository<Delivery, Serializable> {
	
	public abstract Delivery findById(long id);
	
	
	
	
}
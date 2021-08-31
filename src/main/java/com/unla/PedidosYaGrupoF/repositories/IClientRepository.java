package com.unla.PedidosYaGrupoF.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.unla.PedidosYaGrupoF.entities.Client;

@Repository("clientRepository")
public interface IClientRepository extends JpaRepository<Client, Serializable> {
	
	public abstract Client findById(long id);
	
	
	
	
}

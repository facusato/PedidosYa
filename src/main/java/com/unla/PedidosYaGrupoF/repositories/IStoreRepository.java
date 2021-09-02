package com.unla.PedidosYaGrupoF.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.PedidosYaGrupoF.entities.Store;

@Repository("storeRepository")
public interface IStoreRepository extends JpaRepository<Store, Serializable>{
	
	public abstract Store findByIdStore(long idStore);
	
}
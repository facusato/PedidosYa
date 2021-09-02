package com.unla.PedidosYaGrupoF.repositories;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unla.PedidosYaGrupoF.entities.Batch;



@Repository("batchRepository")
public interface IBatchRepository extends JpaRepository<Batch, Serializable> {
	
	public abstract Batch findByIdBatch(long idBatch);
	
	//Consulta que trae una lista de lotes con ese id de local
	@Query("SELECT b FROM Batch b JOIN FETCH b.store s WHERE s.idStore = (:idStore)")
	public abstract List<Batch> findByIdStore(long idStore);
	
	
	//Consulta que trae una lista de lotes que tengan ese id de producto
	@Query("SELECT b FROM Batch b JOIN FETCH b.product p WHERE p.idProduct = (:idProduct)")
	public abstract List<Batch> findByIdProduct(long idProduct);
	
}
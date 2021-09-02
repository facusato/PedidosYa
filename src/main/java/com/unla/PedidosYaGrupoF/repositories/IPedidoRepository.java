package com.unla.PedidosYaGrupoF.repositories;

import java.io.Serializable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.unla.PedidosYaGrupoF.entities.Pedido;

@Repository("pedidoRepository")
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable> {
	
	public abstract Pedido findByIdPedido(long idPedido);
	
	//ver si la necesito
	@Query("SELECT p FROM Pedido p JOIN FETCH p.store s WHERE s.idStore = (:idStore)")
	public abstract List<Pedido> findByIdStore(long idStore);

}
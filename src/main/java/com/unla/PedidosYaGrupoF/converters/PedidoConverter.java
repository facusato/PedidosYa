package com.unla.PedidosYaGrupoF.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.unla.PedidosYaGrupoF.entities.Pedido;

import com.unla.PedidosYaGrupoF.models.PedidoModel;

@Component("pedidoConverter")
public class PedidoConverter {
	
	@Autowired()
	@Qualifier("productConverter")
	private ProductConverter productConverter;
	
	@Autowired()
	@Qualifier("storeConverter")
	private StoreConverter storeConverter;
	
	
	@Autowired()
	@Qualifier("clientConverter")
	private ClientConverter clientConverter;

	
	public PedidoModel entityToModel(Pedido pedido) {
		return new PedidoModel(pedido.getIdPedido(),pedido.getQuantity(),productConverter.entityToModel(pedido.getProduct()),storeConverter.entityToModel(pedido.getStore()),pedido.getDate(),pedido.getSubtotal(),pedido.isAccept(),clientConverter.entityToModel(pedido.getClient()));
	}
	
	public Pedido modelToEntity(PedidoModel pedidoModel) {
		return new Pedido(pedidoModel.getIdPedido(),pedidoModel.getQuantity(),productConverter.modelToEntity(pedidoModel.getProduct()),storeConverter.modelToEntity(pedidoModel.getStore()),pedidoModel.getDate(),pedidoModel.getSubtotal(),pedidoModel.isAccept(),clientConverter.modelToEntity(pedidoModel.getClient()));
	}

}

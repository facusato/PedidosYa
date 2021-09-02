package com.unla.PedidosYaGrupoF.services;

import java.util.List;

import com.unla.PedidosYaGrupoF.entities.Delivery;
import com.unla.PedidosYaGrupoF.models.DeliveryModel;

public interface YDeliveryService {
	
	public abstract List<Delivery> getAll();

	public List<DeliveryModel> getAlls();
	
	public DeliveryModel findById(long id);
	
	public DeliveryModel findByName(String name);
	
	public DeliveryModel insertOrUpdate(DeliveryModel clientModel);
	
	public boolean remove(long id);

}

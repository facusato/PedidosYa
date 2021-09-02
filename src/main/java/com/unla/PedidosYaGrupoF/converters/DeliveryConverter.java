package com.unla.PedidosYaGrupoF.converters;

import org.springframework.stereotype.Component;

import com.unla.PedidosYaGrupoF.entities.Delivery;
import com.unla.PedidosYaGrupoF.models.DeliveryModel;

@Component("deliveryConverter")
public class DeliveryConverter {

	public DeliveryModel entityToModel(Delivery delivery) {
		return new DeliveryModel(delivery.getId(),delivery.getName(),delivery.getSurname(),delivery.getDateBirth(),delivery.getDni(),delivery.getHoraIngreso(),delivery.getHoraEgreso());
	}

	public Delivery modelToEntity(DeliveryModel deliveryModel) {
		return new Delivery(deliveryModel.getId(),deliveryModel.getName(),deliveryModel.getSurname(),deliveryModel.getDateBirth(),deliveryModel.getDni(),deliveryModel.getHoraIngreso(),deliveryModel.getHoraEgreso());
}
}

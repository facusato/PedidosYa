package com.unla.PedidosYaGrupoF.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.PedidosYaGrupoF.models.DeliveryModel;
import com.unla.PedidosYaGrupoF.converters.DeliveryConverter;
import com.unla.PedidosYaGrupoF.repositories.IDeliveryRepository;
import com.unla.PedidosYaGrupoF.services.YDeliveryService;
import com.unla.PedidosYaGrupoF.entities.*;
import java.util.*;


	@Service("deliveryService")
	public class DeliveryService implements YDeliveryService {

		@Autowired
		@Qualifier("deliveryRepository")
		private IDeliveryRepository deliveryRepository;
		
		@Autowired
		@Qualifier("deliveryConverter")
		private DeliveryConverter deliveryConverter;
		
		@Override
		public List<Delivery> getAll() {
			return deliveryRepository.findAll();
		}

		@Override
		public DeliveryModel insertOrUpdate(DeliveryModel deliveryModel) {
			Delivery delivery = deliveryRepository.save(deliveryConverter.modelToEntity(deliveryModel));
			return deliveryConverter.entityToModel(delivery);
		}
		
		
		@Override
		public List<DeliveryModel> getAlls() {
			List<DeliveryModel> models = new ArrayList<DeliveryModel>();
			for (Delivery delivery : deliveryRepository.findAll()) {
				models.add(deliveryConverter.entityToModel(delivery));
			}
			return models;
		}

		@Override
		public boolean remove(long id) {
			try {
				deliveryRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}
		}

		@Override
		public DeliveryModel findById(long id) {
			return deliveryConverter.entityToModel(deliveryRepository.findById(id));
		}

		@Override
		public DeliveryModel findByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		
}

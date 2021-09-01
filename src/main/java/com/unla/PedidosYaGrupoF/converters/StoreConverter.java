package com.unla.PedidosYaGrupoF.converters;

import org.springframework.stereotype.Component;

import com.unla.PedidosYaGrupoF.entities.Store;
import com.unla.PedidosYaGrupoF.models.StoreModel;

@Component("storeConverter")
public class StoreConverter {
	
	public StoreModel entityToModel(Store store) {
		return new StoreModel(store.getIdStore(),store.getPhone(),store.getAddress(), store.getLatitude(),store.getLongitude(),store.getDistance());
	}
	
	public Store modelToEntity(StoreModel storeModel) {
		return new Store(storeModel.getIdStore(), storeModel.getPhone(), storeModel.getAddress(), storeModel.getLatitude(),storeModel.getLongitude(),storeModel.getDistance());
	}

}

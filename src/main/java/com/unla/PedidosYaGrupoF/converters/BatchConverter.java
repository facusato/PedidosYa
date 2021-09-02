package com.unla.PedidosYaGrupoF.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unla.PedidosYaGrupoF.models.BatchModel;
import com.unla.PedidosYaGrupoF.entities.Batch;

@Component("batchConverter")
public class BatchConverter {
	
	@Autowired()
	@Qualifier("productConverter")
	private ProductConverter productConverter;
	
	@Autowired()
	@Qualifier("storeConverter")
	private StoreConverter storeConverter;
	
	public BatchModel entityToModel(Batch batch) {
		return new BatchModel(batch.getIdBatch(),productConverter.entityToModel(batch.getProduct()),batch.getQuantity(),batch.getQuantities(),batch.getDate(),storeConverter.entityToModel(batch.getStore()),batch.isActive());
	}
	
	public Batch modelToEntity(BatchModel batchModel) {
		return new Batch(batchModel.getIdBatch(),productConverter.modelToEntity(batchModel.getProduct()),batchModel.getQuantity(),batchModel.getQuantities(),batchModel.getDate(),storeConverter.modelToEntity(batchModel.getStore()),batchModel.isActive());
	}

}
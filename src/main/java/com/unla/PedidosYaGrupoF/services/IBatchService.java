package com.unla.PedidosYaGrupoF.services;

import java.util.List;

import com.unla.PedidosYaGrupoF.entities.Batch;
import com.unla.PedidosYaGrupoF.models.BatchModel;

public interface  IBatchService {
	
	 
	    public  List<Batch> getAll();
	   
	    public  List<BatchModel> getAlls();
		
		public   BatchModel insert(BatchModel batchModel);
		
		public  BatchModel update(BatchModel batchModel);
		
		public  boolean remove(long idBatch);

		public  BatchModel findByIdBatch(long idBatch);
		
		public  List<BatchModel> findByIdStore(long idStore);

		public List<BatchModel> findByIdProduct(long idProduct);

		
}

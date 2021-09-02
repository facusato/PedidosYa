package com.unla.PedidosYaGrupoF.services;

import com.unla.PedidosYaGrupoF.entities.Store;
//import com.unla.PedidosYaGrupoF.models.ProductModel;
import com.unla.PedidosYaGrupoF.models.StoreModel;


//import java.time.LocalDate;
import java.util.List;


public interface IStoreService {
	
	public List<Store> getAll();
	
	public List<StoreModel> getAlls();
	
	public StoreModel findByIdStore(long idStore);
	
	public StoreModel insert(StoreModel storeModel);
	
	public StoreModel update(StoreModel storeModel);
	
	public boolean remove(long idStore);

	//public List<StoreModel> getNearestStore(StoreModel storeModel);

	//public List<ProductModel> soldProductsBetweenDates(StoreModel store, LocalDate since, LocalDate until);

	//public List<StoreModel> storeStockRequest(StoreModel storeModel, ProductModel productModel, int cantidad);


}
package com.unla.PedidosYaGrupoF.services;

import java.util.List;
import com.unla.PedidosYaGrupoF.entities.Product;
import com.unla.PedidosYaGrupoF.models.ProductModel;

public interface IProductService {

	public  List<Product> getAll();
	
	public  List<ProductModel> getAlls();
	
	public  ProductModel findByIdProduct(long idProduct);
	
	public List<ProductModel> findByName(String name);
	
	public boolean remove(long idProduct);

	public ProductModel insertOrUpdate(ProductModel productModel);
	
	public List<ProductModel> findByDescriptionName(String descriptionName);
	
	
	
}
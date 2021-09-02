package com.unla.PedidosYaGrupoF.services.implementation;



import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.PedidosYaGrupoF.converters.ProductConverter;
import com.unla.PedidosYaGrupoF.entities.Product;
import com.unla.PedidosYaGrupoF.models.ProductModel;
import com.unla.PedidosYaGrupoF.repositories.IProductRepository;
import com.unla.PedidosYaGrupoF.services.IProductService;


@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	@Qualifier("productRepository")
	private IProductRepository productRepository;
	
	@Autowired
	@Qualifier("productConverter")
	private ProductConverter productConverter;
	
	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	@Override
	public ProductModel insertOrUpdate(ProductModel productModel) {
		Product product = productRepository.save(productConverter.modelToEntity(productModel));
		return productConverter.entityToModel(product);
	}
	
	@Override
	public ProductModel findByIdProduct(long idProduct) {
		return productConverter.entityToModel(productRepository.findByIdProduct(idProduct));
	}
	
	@Override
	public List<ProductModel> findByName(String name) {
		List<ProductModel> models = new ArrayList<ProductModel>();
		for (Product product : productRepository.findByName(name)) {
			models.add(productConverter.entityToModel(product));
		}
		return models;
	}
	

	@Override
	public List<ProductModel> findByDescriptionName(String descriptionName) {
		List<ProductModel> models = new ArrayList<ProductModel>();
		for (Product product : productRepository.findByDescriptionName(descriptionName)) {
			models.add(productConverter.entityToModel(product));
		}
		return models;
	}
	
	
	@Override
	public List<ProductModel> getAlls() {
		List<ProductModel> models = new ArrayList<ProductModel>();
		for (Product product : productRepository.findAll()) {
			models.add(productConverter.entityToModel(product));
		}
		return models;
	}
	
	
	@Override
	public boolean remove(long idProduct) {
		try {
			productRepository.deleteById(idProduct);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
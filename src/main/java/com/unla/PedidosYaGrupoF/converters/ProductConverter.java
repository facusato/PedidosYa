package com.unla.PedidosYaGrupoF.converters;

import org.springframework.stereotype.Component;

import com.unla.PedidosYaGrupoF.entities.Product;
import com.unla.PedidosYaGrupoF.models.ProductModel;

@Component("productConverter")
public class ProductConverter {

	public ProductModel entityToModel(Product product) {
		return new ProductModel(product.getIdProduct(),product.getName(), product.getDescription(),product.getPrice(),product.getPic());
	}

	public Product modelToEntity(ProductModel productModel) {
		return new Product(productModel.getIdProduct(),productModel.getName(), productModel.getDescription(),productModel.getPrice(),productModel.getPic());
	}
}
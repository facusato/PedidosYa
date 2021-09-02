package com.unla.PedidosYaGrupoF.models;


public class ProductModel {
	
	
	private long idProduct;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private String pic;
	
	
	
	public ProductModel() {}
	
	public ProductModel(long idProduct,String name,String description,double price,String pic) {
		this.setIdProduct(idProduct);	
		this.name=name;
		this.description=description;
		this.price=price;
		this.pic=pic;
	
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	

}

package com.unla.PedidosYaGrupoF.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idProduct;
	
	@Column(name="name")
	String name;
	
	@Column(name="description")
	String description;
	
	@Column(name="price")
	double price;
	
	@Column(name="pic")
	String pic;

	public Product() {}

	public Product(long idProduct,String name, String description, double price,String pic) {
		this.idProduct = idProduct;
		this.name=name;
		this.description = description;
		this.price = price;
		this.pic=pic;
		

	}

	public Product(String name,String description, double price,String pic) {
		this.name=name;
		this.description = description;
		this.price = price;
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

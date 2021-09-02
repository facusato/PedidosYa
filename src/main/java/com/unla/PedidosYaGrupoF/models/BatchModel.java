package com.unla.PedidosYaGrupoF.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class BatchModel {
	
	private long idBatch;
	
	private ProductModel product;
	
	private int quantity;
	
	private int quantities;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	private StoreModel store;
	
	private boolean active;
	
	
	
	public BatchModel() {}

	public BatchModel(long idBatch, ProductModel product, int quantity, int quantities,LocalDate date,StoreModel store,boolean active) {
		this.setIdBatch(idBatch);
		this.product = product;
		this.quantity = quantity;
		this.quantities = quantities;
		this.date=date;
		this.store=store;
		this.active=active;
	
	}

	public long getIdBatch() {
		return idBatch;
	}

	public void setIdBatch(long idBatch) {
		this.idBatch = idBatch;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public StoreModel getStore() {
		return store;
	}

	public void setStore(StoreModel store) {
		this.store = store;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
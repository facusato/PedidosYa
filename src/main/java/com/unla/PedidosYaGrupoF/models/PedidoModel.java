package com.unla.PedidosYaGrupoF.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public class PedidoModel {
	
	private long idPedido;
	private int quantity;
	private ProductModel product;
	private StoreModel store;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private double subtotal;
	private boolean accept;
	private ClientModel client;
	
	
	public PedidoModel() {}

	public PedidoModel(long idPedido, int quantity, ProductModel product,StoreModel store,LocalDate date,double subtotal,boolean accept,ClientModel client) {
		this.setIdPedido(idPedido);
		this.quantity = quantity;
		this.product = product;
		this.store=store;
		this.date=date;
		this.subtotal=subtotal;
		this.accept=accept;
		this.client=client;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}
	
	
}

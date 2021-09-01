package com.unla.PedidosYaGrupoF.entities;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.sun.istack.Nullable;


@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	
	@Column(name="quantity")
	private int quantity;
	
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Product product;
	
	@OneToOne
	private Store store;
	
	@Column(name="date")
	LocalDate date;
	
	@Column(name="subtotal")
	double subtotal;
	
	private boolean accept;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Client client;
	
	public Pedido() {}
	
	public Pedido(long idPedido,int quantity,Product product,Store store,LocalDate date,double subtotal,boolean accept,Client client) {
		this.idPedido=idPedido;
		this.quantity=quantity;
		this.product=product;
		this.store=store;
		this.date=date;
		this.subtotal=subtotal;
		this.accept=accept;
		this.client=client;
	}
	
	public Pedido(int quantity,Product product,Store store,LocalDate date,double subtotal,boolean accept,Client client) {
		this.quantity=quantity;
		this.product=product;
		this.store=store;
		this.subtotal=subtotal;
		this.date=date;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}

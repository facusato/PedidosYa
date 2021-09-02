package com.unla.PedidosYaGrupoF.entities;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="batch")
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBatch;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Product product;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="quantities")
	private int quantities;
	
	@Column(name="date")
	private LocalDate date;
	
	//lado propietario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="store_id", nullable=false)
	private Store store;
	
	@Column(name="active")
	private boolean active;
	


	public Batch() {}

	public Batch(long idBatch,Product product, int quantity, int quantities,LocalDate date,Store store,boolean active) {
		this.idBatch=idBatch;
		this.product = product;
		this.quantity = quantity;
		this.quantities = quantities;
		this.date=date;
		this.store=store;
		this.active=active;
	}
	
	public Batch(Product product, int quantity, int quantities,LocalDate date,Store store,boolean active) {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}
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
@Table(name="food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFood;
	/*
	@OneToOne(cascade=CascadeType.MERGE)
	private Product product;
	*/
	@Column(name="quantity")
	private int quantity;
	
	
	@Column(name="date")
	private LocalDate date;
	
	//lado propietario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="store_id", nullable=false)
	private Store store;
	
	@Column(name="active")
	private boolean active;
	


	public Food() {}

	public Food(long idFood, int quantity,LocalDate date,Store store,boolean active) {
		this.idFood=idFood;
		//this.product = product;
		this.quantity = quantity;
		this.date=date;
		this.store=store;
		this.active=active;
	}
	
	public Food(int quantity,LocalDate date,Store store,boolean active) {
		//this.product = product;
		this.quantity = quantity;
		this.date=date;
		this.store=store;
		this.active=active;

	}

	
	
	
	public long getIdFood() {
		return idFood;
	}

	public void setIdFood(long idFood) {
		this.idFood = idFood;
	}

	/*
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
*/
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
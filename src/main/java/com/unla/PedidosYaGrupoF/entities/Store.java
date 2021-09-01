package com.unla.PedidosYaGrupoF.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;




@Entity
@Table(name="store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStore;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;
	
	@Column(name="distance")
	private double distance;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="store")
	private Set<Product> products = new HashSet<Product>();
	
	
	public Store() {}
	
	public Store(long idStore, long phone, String address,double latitude, double longitude,double distance) {
		this.idStore = idStore;
		this.phone = phone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance=distance;
	}
	
	public Store( long phone, String address,float latitude, float longitude) {
		this.phone = phone;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		
	}
	
	public long getIdStore() {
		return idStore;
	}

	public void setIdStore(long idStore) {
		this.idStore = idStore;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
         
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
		double radioTierra = 6371;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
		+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
		}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
}
package com.unla.PedidosYaGrupoF.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Delivery extends Person {
	
	@Column(name="horaIngreso")
	private int horaIngreso;
	
	@Column(name="horaEgreso")
	private int horaEgreso;
	
public Delivery() {}
	
	public Delivery(long id,String name,String surname,LocalDate dateBirth,long dni,int horaIngreso,int horaEgreso) {
		super(id,name,surname,dateBirth,dni);
		this.horaIngreso=horaIngreso;
		this.horaEgreso=horaEgreso;
	}

	public int getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(int horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public int getHoraEgreso() {
		return horaEgreso;
	}

	public void setHoraEgreso(int horaEgreso) {
		this.horaEgreso = horaEgreso;
	}
	
	

}

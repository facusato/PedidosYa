package com.unla.PedidosYaGrupoF.models;

import java.time.LocalDate;


public class DeliveryModel extends PersonModel {

	private int horaIngreso;
	private int horaEgreso;
	
public DeliveryModel() {}
	
	public DeliveryModel(long id,String name,String surname,LocalDate dateBirth,long dni,int horaIngreso,int horaEgreso) {
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

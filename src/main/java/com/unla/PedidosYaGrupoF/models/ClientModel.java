package com.unla.PedidosYaGrupoF.models;

import java.time.LocalDate;


public class ClientModel extends PersonModel {

	private String mail;
	
public ClientModel() {}
	
	public ClientModel(long id,String name,String surname,LocalDate dateBirth,long dni, String mail) {
		super(id,name,surname,dateBirth,dni);
		this.mail = mail;
		
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
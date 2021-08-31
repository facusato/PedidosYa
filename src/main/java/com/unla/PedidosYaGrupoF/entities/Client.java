package com.unla.PedidosYaGrupoF.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Client extends Person {
	@Column(name="mail")
	private String mail;
	
	public Client() {}
	
	public Client(long id,String name,String surname,LocalDate dateBirth,long dni, String mail) {
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
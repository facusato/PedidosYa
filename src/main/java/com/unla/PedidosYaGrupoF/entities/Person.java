package com.unla.PedidosYaGrupoF.entities;
import java.time.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //See more in https://www.baeldung.com/hibernate-inheritance
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String surname;
	
	private LocalDate dateBirth;
	
	private long dni;

	public Person() {}
	
	public Person(long id, String name,String surname, LocalDate dateBirth,long dni) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dateBirth = dateBirth;
		this.dni = dni;
	}
	
	public Person( String name,String surname, LocalDate dateBirth,long dni) {
		this.name = name;
		this.surname = surname;
		this.dateBirth = dateBirth;
		this.dni = dni;
	}
	


	public Person(String name) {
		this.name = name;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}


}
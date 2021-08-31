package com.unla.PedidosYaGrupoF.converters;


import org.springframework.stereotype.Component;

import com.unla.PedidosYaGrupoF.entities.Person;
import com.unla.PedidosYaGrupoF.models.PersonModel;

@Component("personConverter")
public class PersonConverter {

	public PersonModel entityToModel(Person person) {
		return new PersonModel(person.getId(), person.getName(), person.getSurname(), person.getDateBirth(), person.getDni());
	}

	public Person modelToEntity(PersonModel personModel) {
		return new Person(personModel.getId(), personModel.getName(),personModel.getSurname(), personModel.getDateBirth(), personModel.getDni());
	}
}
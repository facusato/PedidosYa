package com.unla.PedidosYaGrupoF.services.implementation;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.PedidosYaGrupoF.models.PersonModel;
import com.unla.PedidosYaGrupoF.converters.PersonConverter;
import com.unla.PedidosYaGrupoF.repositories.IPersonRepository;
import com.unla.PedidosYaGrupoF.services.*;
import com.unla.PedidosYaGrupoF.entities.*;
import java.util.*;


@Service("personService")
public class PersonService implements IPersonService {

		@Autowired
		@Qualifier("personRepository")
		private IPersonRepository personRepository;
		
		@Autowired
		@Qualifier("personConverter")
		private PersonConverter personConverter;
		
		@Override
		public List<Person> getAll() {
			return personRepository.findAll();
		}

		@Override
		public PersonModel insertOrUpdate(PersonModel personModel) {
			Person person = personRepository.save(personConverter.modelToEntity(personModel));
			return personConverter.entityToModel(person);
		}
		
		@Override
		public List<PersonModel> getAlls() {
			List<PersonModel> models = new ArrayList<PersonModel>();
			for (Person person : personRepository.findAll()) {
				models.add(personConverter.entityToModel(person));
			}
			return models;
		}

		@Override
		public boolean remove(long id) {
			try {
				personRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}
		}

		@Override
		public PersonModel findById(long id) {
			return personConverter.entityToModel(personRepository.findById(id));
		}

		@Override
		public PersonModel findByName(String name) {
			return personConverter.entityToModel(personRepository.findByName(name));
		}
		
	

}
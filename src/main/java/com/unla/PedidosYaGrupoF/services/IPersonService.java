package com.unla.PedidosYaGrupoF.services;

import com.unla.PedidosYaGrupoF.entities.Person;
import com.unla.PedidosYaGrupoF.models.PersonModel;

import java.util.*;

public interface IPersonService {
	
    public List<Person> getAll();

    public List<PersonModel> getAlls();

	public PersonModel findById(long id);
	
	public PersonModel findByName(String name);
	
	public PersonModel insertOrUpdate(PersonModel personModel);
	
	public boolean remove(long id);
	
	
}
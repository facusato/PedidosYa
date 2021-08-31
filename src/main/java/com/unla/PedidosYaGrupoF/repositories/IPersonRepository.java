package com.unla.PedidosYaGrupoF.repositories;
import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
	
import org.springframework.stereotype.Repository;

import com.unla.PedidosYaGrupoF.entities.*;

	@Repository("personRepository")
	public interface IPersonRepository extends JpaRepository<Person, Serializable> {
		
		public abstract Person findById(long id);
		
		public abstract Person findByName(String name);
		
		
	}

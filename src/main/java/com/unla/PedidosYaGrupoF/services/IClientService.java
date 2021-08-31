package com.unla.PedidosYaGrupoF.services;

import com.unla.PedidosYaGrupoF.entities.Client;
import com.unla.PedidosYaGrupoF.models.ClientModel;

import java.util.*;

public interface IClientService {
    
	public abstract List<Client> getAll();

	public List<ClientModel> getAlls();
	
	public ClientModel findById(long id);
	
	public ClientModel findByName(String name);
	
	public ClientModel insertOrUpdate(ClientModel clientModel);
	
	public boolean remove(long id);
	
	
}
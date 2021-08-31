package com.unla.PedidosYaGrupoF.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.PedidosYaGrupoF.models.ClientModel;
import com.unla.PedidosYaGrupoF.converters.ClientConverter;
import com.unla.PedidosYaGrupoF.repositories.IClientRepository;
import com.unla.PedidosYaGrupoF.services.IClientService;
import com.unla.PedidosYaGrupoF.entities.*;
import java.util.*;


	@Service("clientService")
	public class ClientService implements IClientService {

		@Autowired
		@Qualifier("clientRepository")
		private IClientRepository clientRepository;
		
		@Autowired
		@Qualifier("clientConverter")
		private ClientConverter clientConverter;
		
		@Override
		public List<Client> getAll() {
			return clientRepository.findAll();
		}

		@Override
		public ClientModel insertOrUpdate(ClientModel clientModel) {
			Client client = clientRepository.save(clientConverter.modelToEntity(clientModel));
			return clientConverter.entityToModel(client);
		}
		
		
		@Override
		public List<ClientModel> getAlls() {
			List<ClientModel> models = new ArrayList<ClientModel>();
			for (Client client : clientRepository.findAll()) {
				models.add(clientConverter.entityToModel(client));
			}
			return models;
		}

		@Override
		public boolean remove(long id) {
			try {
				clientRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}
		}

		@Override
		public ClientModel findById(long id) {
			return clientConverter.entityToModel(clientRepository.findById(id));
		}

		@Override
		public ClientModel findByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		
}
package com.unla.PedidosYaGrupoF.converters;

import org.springframework.stereotype.Component;


import com.unla.PedidosYaGrupoF.entities.Client;
import com.unla.PedidosYaGrupoF.models.ClientModel;;

@Component("clientConverter")
public class ClientConverter {

	public ClientModel entityToModel(Client client) {
		return new ClientModel(client.getId(),client.getName(),client.getSurname(),client.getDateBirth(),client.getDni(),client.getMail());
	}

	public Client modelToEntity(ClientModel clientModel) {
		return new Client(clientModel.getId(),clientModel.getName(),clientModel.getSurname(),clientModel.getDateBirth(),clientModel.getDni(),clientModel.getMail());
}
}
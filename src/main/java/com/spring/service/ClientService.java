package com.spring.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Client;
import com.spring.repository.ClientRepository;


@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> getAllClients(){
		List<Client> clientList = new ArrayList<>();
		clientRepository.findAll().forEach(clientList::add);
		return clientList;
	}
	
	public List<Client> getClientById(int idClient){
		
		List<Client> clientList = new ArrayList<>();
		clientList.add(clientRepository.findById(idClient).get());
		return clientList;
	}

	public Client saveClient(Client client) {
		
		return this.clientRepository.save(client);

		
	}

	public String deleteClient(Client client) {
		// TODO Auto-generated method stub
		clientRepository.delete(client);
		return "Deleted";
	}

	public String deleteClientById(int clientId) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(clientId);
		return "Deleted";
	}

	
	public List<Object[]> totalVenteGenre(){
		return this.clientRepository.totalVenteGenre();
	}
	
	
}
	


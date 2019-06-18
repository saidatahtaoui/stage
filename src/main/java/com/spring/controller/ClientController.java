package com.spring.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Client;
import com.spring.repository.ClientRepository;
import com.spring.service.ClientService;

@RestController
@RequestMapping(path="/client")
public class ClientController {
	
	
	@Autowired 
	ClientService clientService;
	@Autowired
	ClientRepository clientRepository;
	@GetMapping(path="/getAllClients")
	public List<Client> getAllClients(){
		List<Client> clientList = new ArrayList<>();
		clientList.addAll(clientService.getAllClients());
		return clientList;
	}
	@GetMapping(path="/getClientById/{clientId}")	
	public List<Client> getClientByNom(@PathVariable(name="clientId")int idClient)	
	{	
	List<Client> clientList = new ArrayList<>();
	clientList.addAll(clientService.getClientById(idClient));
	return clientList;
	}
	@PostMapping(path="/saveClient")
	public Client saveClient (Client client)
	{
		return clientService.saveClient(client);
	}
	@DeleteMapping(path="/deleteClient")
	public String deleteClient(@RequestBody Client client ) {
		return clientService.deleteClient(client);
	}
	@DeleteMapping(path="/deleteClientId/{clientId}")
	public String deleteClientById(@PathVariable(name="clientId")int clientId) {
		return clientService.deleteClientById(clientId);
	}
	@PutMapping("/updatecommande/{id}")
	public ResponseEntity<Object> updateCommande(@RequestBody Client commande, @PathVariable int id) {

		java.util.Optional<Client> commandeOptional = clientRepository.findById(id);

		if (!commandeOptional.isPresent())
			return ResponseEntity.notFound().build();

		commande.setIdClient(id);
		
		clientRepository.save(commande);

		return ResponseEntity.noContent().build();
	}
	
}



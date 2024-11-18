package com.bp.moneymanager.services;

import com.bp.moneymanager.exceptions.NotFoundException;
import com.bp.moneymanager.models.Client;
import com.bp.moneymanager.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client not found"));
    }

    public Client update(Long id, Client client) {
        Client clientToUpdate = this.findById(id);
        client.setId(clientToUpdate.getId());
        return clientRepository.save(client);
    }

    public Client delete(Long id) {
        Client client = this.findById(id);
        clientRepository.deleteById(id);
        return client;
    }
}

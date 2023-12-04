package com.beautysalon.service;

import com.beautysalon.controller.dto.ClientRequest;
import com.beautysalon.controller.dto.ClientResponse;
import com.beautysalon.repository.ClientRepository;
import com.beautysalon.repository.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public void save(ClientRequest clientRequest) {
        Client client = clientMapper.map(clientRequest);
        clientRepository.save(client);
    }

    public ClientResponse findResponseByEmail(String email) {
        final Client client = clientRepository.findByEmail(email);
        return clientMapper.map(client);
    }

    public ClientResponse findResponseById(Integer id) {
        final Client client = clientRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.map(client);
    }

    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

    public List<Client> findResponseByName(String name) {
        return clientRepository.findByName(name);
    }
}
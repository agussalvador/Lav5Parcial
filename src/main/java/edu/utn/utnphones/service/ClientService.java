package edu.utn.utnphones.service;

import edu.utn.utnphones.domain.Client;
import edu.utn.utnphones.dto.ClientPhoneLineRequestDto;
import edu.utn.utnphones.exceptions.ClientAlreadyExistsException;
import edu.utn.utnphones.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService{

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id){
        return clientRepository.findById(id).get();
    }

    public void addClient(ClientPhoneLineRequestDto clientPhoneLineRequestDto) throws ClientAlreadyExistsException {
        clientRepository.addClient(clientPhoneLineRequestDto.getCity(), clientPhoneLineRequestDto.getFirstname(), clientPhoneLineRequestDto.getLastname(), clientPhoneLineRequestDto.getDni(), clientPhoneLineRequestDto.getPassword(), clientPhoneLineRequestDto.getTypeLine() );
    }

}

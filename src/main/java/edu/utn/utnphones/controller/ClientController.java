package edu.utn.utnphones.controller;

import edu.utn.utnphones.domain.Client;
import edu.utn.utnphones.dto.ClientPhoneLineRequestDto;
import edu.utn.utnphones.exceptions.ClientAlreadyExistsException;
import edu.utn.utnphones.projection.ClientCallsParcial;
import edu.utn.utnphones.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable Integer clientId) {
        return clientService.getClientById(clientId);
    }

    @PostMapping
    public void registerClient(@RequestBody ClientPhoneLineRequestDto clientPhoneLineRequestDto) throws ClientAlreadyExistsException {

        clientService.addClient(clientPhoneLineRequestDto);
    }

    @GetMapping("/parcial")
    public List<ClientCallsParcial> getClientCallsParcial(@RequestParam String clientDni, @RequestParam Double price) {
        return clientService.getClientCallsParcial(clientDni, price);
    }

    //todo remove client



}

package edu.utn.utnphones.controller.backoffice;

import edu.utn.utnphones.controller.UserController;
import edu.utn.utnphones.domain.User;
import edu.utn.utnphones.dto.ClientRequestDto;
import edu.utn.utnphones.exceptions.UserAlreadyExistsException;
import edu.utn.utnphones.exceptions.UserNotFoundException;
import edu.utn.utnphones.exceptions.ValidationException;
import edu.utn.utnphones.projection.ClientView;
import edu.utn.utnphones.session.SessionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ClientBackOfficeControllerTest {

    ClientView clientView;
    ClientBackOfficeController clientBackOfficeController;
    @Mock
    private UserController userController;
    @Mock
    private SessionManager sessionManager;

    @BeforeEach
    void setUp() {
        initMocks(this);
        clientBackOfficeController = new ClientBackOfficeController(userController, sessionManager);
        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        clientView = factory.createProjection(ClientView.class);
        clientView.setDni("4333444");
        clientView.setFullNumber("0223155673636");
        clientView.setCityAndProvince("Mar del plata, Buenos aires");
        clientView.setCountPhoneLines(1);
    }
/*
    @Test
    void addNewClient() throws UserAlreadyExistsException {
        User user = new User((long) 1, "4333444", "santiago", "labatut", "pwd123", true, Role.client, null);
        ClientRequestDto clientRequestDto = new ClientRequestDto((long) 1, "Santiago", "labatut", "4333444", "pwd123", TypeLine.home);
        when(userController.addClient(clientRequestDto)).thenReturn(user);
        URI uri = clientBackOfficeController.getLocation(user);
        ResponseEntity response = ResponseEntity.created(uri).build();
        ResponseEntity<User> response1 = clientBackOfficeController.addNewClient(clientRequestDto);

        assertEquals(response, response1);

    }
*/
    @Test
    void getClientByDniOk() throws UserNotFoundException, ValidationException {
        when(userController.getClientByDni("4333444")).thenReturn(clientView);
        ResponseEntity response = ResponseEntity.ok(clientView);
        ResponseEntity<ClientView> response1 = clientBackOfficeController.getClientByDni("Authorization","4333444");

        assertEquals(response, response1);
    }

    @Test
    void getClientByDniException() throws UserNotFoundException, ValidationException {

        when(userController.getClientByDni("4333444")).thenThrow((new JpaSystemException(new RuntimeException(new SQLException()))));

        assertThrows(UserNotFoundException.class, () -> {clientBackOfficeController.getClientByDni("Authorization","4333444");
        });
    }

    @Test
    void getAllUsersOk() {
        List<ClientView> clients = new ArrayList<>();
        clients.add(clientView);
        when(userController.getAllClients()).thenReturn(clients);
        ResponseEntity<List<ClientView>> responseEntity = clientBackOfficeController.getAllUsers("Authorization");

        assertEquals(responseEntity.getBody().size(),clients.size());
        assertEquals(responseEntity.getBody().get(0).getDni(),clients.get(0).getDni());

    }
    @Test
    void getAllUsersException() {

        when(userController.getAllClients()).thenThrow((new JpaSystemException(new RuntimeException(new SQLException()))));


    }



    @Test
    void updateUserByDni() {
    }

    @Test
    void deleteClient() {
    }
}
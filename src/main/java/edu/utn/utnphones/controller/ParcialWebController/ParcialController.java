package edu.utn.utnphones.controller.ParcialWebController;

import edu.utn.utnphones.controller.CallController;
import edu.utn.utnphones.exceptions.PhoneLineNotFoundException;

import edu.utn.utnphones.projection.ClientCallsParcial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Parcial")
public class ParcialController {

    private final CallController callController;


    @Autowired
    public ParcialController(CallController callController) {
        this.callController = callController;

    }

    @GetMapping("/")
    public ResponseEntity<List<ClientCallsParcial>>getCallsByPhone(@RequestParam String phone) throws PhoneLineNotFoundException {
        List<ClientCallsParcial> calls = new ArrayList<>();
        try {
            calls = callController.getCallsByPhone(phone);
            return (calls.size() > 0) ? ResponseEntity.ok(calls) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (JpaSystemException e){
            throw new PhoneLineNotFoundException();
        }

    }

}

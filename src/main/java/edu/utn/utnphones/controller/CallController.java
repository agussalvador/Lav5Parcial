package edu.utn.utnphones.controller;

import edu.utn.utnphones.projection.ClientCallsParcial;
import edu.utn.utnphones.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CallController {

    private final CallService callService;

    @Autowired
    public CallController(CallService callService) {
        this.callService = callService;
    }

    public List<ClientCallsParcial> getCallsByPhone(String phone) throws JpaSystemException {
        List<ClientCallsParcial> calls = callService.getCallsByPhone(phone);
        return calls;
    }
}

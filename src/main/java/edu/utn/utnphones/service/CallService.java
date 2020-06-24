package edu.utn.utnphones.service;

import edu.utn.utnphones.projection.ClientCallsParcial;
import edu.utn.utnphones.repository.CallDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService {

    private final CallDao callDao;

    @Autowired
    public CallService(CallDao callDao) {
        this.callDao = callDao;
    }

    public List<ClientCallsParcial> getCallsByPhone(String phone) throws JpaSystemException {
        List<ClientCallsParcial> calls = callDao.getCallsByPhone(phone);
        return calls;
    }









}

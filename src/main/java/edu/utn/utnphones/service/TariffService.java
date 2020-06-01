package edu.utn.utnphones.service;


import edu.utn.utnphones.domain.Bill;
import edu.utn.utnphones.domain.Tariff;
import edu.utn.utnphones.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffService {

    private final TariffRepository tariffRepository;

    @Autowired
    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public List<Tariff> getTariffs() {
        return tariffRepository.findAll();
    }

    public Tariff getTariffById(Integer tariffId) {
        return tariffRepository.findById(tariffId).get();
    }

}

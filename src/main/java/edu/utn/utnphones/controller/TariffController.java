package edu.utn.utnphones.controller;

import edu.utn.utnphones.domain.Tariff;

import edu.utn.utnphones.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tariff")
public class TariffController {

    private final TariffService tariffService;

    @Autowired
    public TariffController(final TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/")
    public List<Tariff> getTariffs() {
        return tariffService.getTariffs();
    }

    @GetMapping("/{tariffId}")
    public Tariff getTariffById(@PathVariable Integer tariffId) {
        return tariffService.getTariffById(tariffId);
    }

}

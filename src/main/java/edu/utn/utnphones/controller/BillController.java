package edu.utn.utnphones.controller;

import edu.utn.utnphones.domain.Bill;
import edu.utn.utnphones.domain.City;
import edu.utn.utnphones.service.BillService;
import edu.utn.utnphones.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(final BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/")
    public List<Bill> getBills() {
        return billService.getBills();
    }

    @GetMapping("/{billId}")
    public Bill getBillById(@PathVariable Integer billId) {
        return billService.getBillById(billId);
    }
}

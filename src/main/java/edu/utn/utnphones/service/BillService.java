package edu.utn.utnphones.service;

import edu.utn.utnphones.domain.Bill;
import edu.utn.utnphones.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> getBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Integer billId) {
        return billRepository.findById(billId).get();
    }
}

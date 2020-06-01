package edu.utn.utnphones.service;

import edu.utn.utnphones.domain.Province;
import edu.utn.utnphones.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    public final ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public List<Province> getProvince() {
        return provinceRepository.findAll();
    }

    public Province getProvinceById(Integer provinceId) {
        return provinceRepository.findById(provinceId).get();
    }


}

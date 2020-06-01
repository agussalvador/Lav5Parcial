package edu.utn.utnphones.controller;

import edu.utn.utnphones.domain.Province;
import edu.utn.utnphones.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    public final ProvinceService provinceService;

    @Autowired
    public ProvinceController(final ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping("/")
    public List<Province> getProvinces() {
        return provinceService.getProvince();
    }

    @GetMapping("/{provinceId}")
    public Province getProvinceById(@PathVariable Integer provinceId) {
        return provinceService.getProvinceById(provinceId);
    }


}

package edu.utn.utnphones.controller;

import edu.utn.utnphones.domain.City;
import edu.utn.utnphones.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(final CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<City> getCities() {
        return cityService.getCities();
    }

    @GetMapping("/{cityId}")
    public City getCityById(@PathVariable Integer cityId) {
        return cityService.getCityById(cityId);
    }


}

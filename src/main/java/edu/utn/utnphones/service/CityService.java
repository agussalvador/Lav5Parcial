package edu.utn.utnphones.service;

import edu.utn.utnphones.domain.City;
import edu.utn.utnphones.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Integer cityId) {
        return cityRepository.findById(cityId).get();
    }

}

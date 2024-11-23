package com.sapient.bookmyshow.services;

import com.sapient.bookmyshow.exceptions.CityNotFoundException;
import com.sapient.bookmyshow.models.City;
import com.sapient.bookmyshow.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private CityRepository cityRepository;
    public City createCity(City request) {
        return cityRepository.save(request);
    }

    public City getCity(Long id) {
        //return cityRepository.findById(id)
                //.orElseThrow(() -> new CityNotFoundException(id));
        return cityRepository.findCityByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public List<City> getallCity() {
        //return cityRepository.findAll();
        return cityRepository.findAllByIsDeletedFalse();
    }

    public List<City> searchCity(String city) {
        //return cityRepository.findByNameContaining(city);
        return cityRepository.findByNameContainingAndIsDeletedFalse(city);
    }

    public City deleteCity(Long id) {
        City existingCity = cityRepository.findCityByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        existingCity.setIsDeleted(true);

        return cityRepository.save(existingCity);
    }

    public City updateCity(Long id, City request) {
        City existingCity = cityRepository.findCityByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        existingCity.setName(request.getName());
        return cityRepository.save(existingCity);
    }
}

package com.theatre.booking.controllers;

import com.theatre.booking.dtos.CreateCityResponse;
import com.theatre.booking.models.City;
import com.theatre.booking.services.CityService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {

    private CityService cityService;
    private ModelMapper modelMapper;

    @PostMapping
    public City createCity(@RequestBody City request) {
        return cityService.createCity(request);
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.getCity(id);
    }

    @GetMapping("/all")
    public List<City> getallCity() {
        return cityService.getallCity();
    }

    @GetMapping("/search/{city}")
    public List<CreateCityResponse> searchCity(@PathVariable String city) {
        return toCityResponseDTO(cityService.searchCity(city));
    }

    @DeleteMapping("/{id}")
    public City deleteCity(@PathVariable Long id) {
        return cityService.deleteCity(id);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City request) {
        return cityService.updateCity(id,request);
    }

    private List<CreateCityResponse> toCityResponseDTO(List<City> city) {
        return city.stream()
                .map(cities -> modelMapper.map(cities, CreateCityResponse.class))
                .toList();
    }
}

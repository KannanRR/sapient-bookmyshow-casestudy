package com.sapient.bookmyshow.services;
import com.sapient.bookmyshow.dtos.CreateTheatreRequest;
import com.sapient.bookmyshow.exceptions.CityNotFoundException;
import com.sapient.bookmyshow.models.City;
import com.sapient.bookmyshow.models.Hall;
import com.sapient.bookmyshow.models.Show;
import com.sapient.bookmyshow.models.Theatre;
import com.sapient.bookmyshow.repositories.TheatreRepository;
import com.sapient.bookmyshow.models.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TheatreService {

    private HallService hallService;
    private ShowService showService;
    private CityService cityService;
    private TheatreRepository theatreRepository;
    public Theatre createTheatre(CreateTheatreRequest request) {
        System.out.println(request.getHalls());
        List<Hall> halls = hallService.getHalls(request.getHalls());
        List<Show> shows = showService.getShows(request.getShows());
        City city = cityService.getCity(request.getCityid());

        System.out.println(halls);
        System.out.println(shows);
        return theatreRepository.save(Theatre.builder().city(city).name(request.getName())
                .address(request.getAddress())
                .halls(halls).shows(shows)
                .isDeleted(false)
                .build());
    }

    public Theatre getTheatre(Long id) {
        //return theatreRepository.findById(id);
        return theatreRepository.findTheatreByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public Theatre deleteTheatre(Long id) {
        Theatre existingTheatre = theatreRepository.findTheatreByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        existingTheatre.setIsDeleted(true);

        return theatreRepository.save(existingTheatre);
    }

    public Theatre updateTheatre(Long id, CreateTheatreRequest request) {
        Theatre existingTheatre = theatreRepository.findTheatreByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        List<Hall> halls = hallService.getHalls(request.getHalls());
        List<Show> shows = showService.getShows(request.getShows());
        City city = cityService.getCity(request.getCityid());

        existingTheatre.setName(request.getName());
        existingTheatre.setAddress(request.getAddress());
        existingTheatre.setCity(city);
        existingTheatre.setHalls(halls);
        existingTheatre.setShows(shows);

        return theatreRepository.save(existingTheatre);
    }
}
package com.theatre.booking.services;

import com.theatre.booking.dtos.CreateShowRequest;
import com.theatre.booking.exceptions.CityNotFoundException;
import com.theatre.booking.exceptions.ResourceNotFoundException;
import com.theatre.booking.repositories.ShowSeatRepository;
import com.theatre.booking.repositories.ShowRepository;
import com.theatre.booking.models.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
@AllArgsConstructor
public class ShowService {

    private final ShowSeatRepository showSeatRepository;
    private HallService hallService;
    private ShowRepository showRepository;
    private MovieService movieService;
    private SeatService seatService;
    private ShowSeatService showSeatService;

    public Show createShow(CreateShowRequest request) {

        Hall hall = hallService.getHall(request.getHallId());

        Movie movie = movieService.getMovie(request.getMovieId());

        LocalDate localDate = request.getStartTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        Show show = Show
                .builder()
                .hall(hall)
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .movie(movie)
                .startDate(localDate)
                .isDeleted(false)
                .isOnline(request.getIsOnline())
                .build();

        Show savedShow = showRepository.save(show);

        // Task 2
        // Get the seats in the hall using HallId
        // Create the showSeats using the savedShow
        List<Seat> seats = seatService.getAll(request.getHallId());

        List<ShowSeat> showSeats = seats.stream()
                .map(seat ->
                        ShowSeat.builder()
                                .seat(seat)
                                .show(savedShow)
                                .build()
                ).toList();

        // Save the show seats
        showSeatRepository.saveAll(showSeats);
        // Save the show again
        //return showRepository.save(savedShow.toBuilder().showSeats(showSeats).build());
        return getShow(savedShow.getId());
    }

    public Show updateShow(Long id, CreateShowRequest request) {
        /*Show existingShow = showRepository.findShowByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));*/

        Show existingShow = showRepository.findShowByIdAndIsOnlineTrueOrIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found"));

        showSeatService.deleteByShowId(existingShow.getId());

        Hall hall = hallService.getHall(request.getHallId());

        Movie movie = movieService.getMovie(request.getMovieId());

        LocalDate localDate = request.getStartTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();


        existingShow.setHall(hall);
        existingShow.setMovie(movie);
        existingShow.setStartTime(request.getStartTime());
        existingShow.setStartDate(localDate);
        existingShow.setDuration(request.getDuration());
        //existingShow.setShowSeats(null);

        System.out.println("Show Id - " + existingShow.getId());


        Show savedShow = showRepository.save(existingShow);

        //return savedShow;

        // Task 2
        // Get the seats in the hall using HallId
        // Create the showSeats using the savedShow
        List<Seat> seats = seatService.getAll(request.getHallId());

        List<ShowSeat> showSeats = seats.stream()
                .map(seat ->
                        ShowSeat.builder()
                                .seat(seat)
                                .show(savedShow)
                                .build()
                ).toList();

        // Save the show seats
        showSeatRepository.saveAll(showSeats);
        // Save the show again
        //return showRepository.save(savedShow.toBuilder().showSeats(showSeats).build());
        return getShow(savedShow.getId());
    }

    public Show getShow(Long id) {
        //return showRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Invalid show ID:" + id));
        return showRepository.findShowByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found"));

    }

    public List<Show> getShows(List<Long> ids) {
        return showRepository.findAllById(ids);
    }

    public Show deleteShow(Long id) {
        Show existingShow = showRepository.findShowByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        existingShow.setIsDeleted(true);

        return showRepository.save(existingShow);
    }
}
package com.sapient.bookmyshow.services;
import com.sapient.bookmyshow.dtos.CreateHallRequest;
import com.sapient.bookmyshow.dtos.CreateTheatreRequest;
import com.sapient.bookmyshow.dtos.SeatPosition;
import com.sapient.bookmyshow.enums.SeatType;
import com.sapient.bookmyshow.exceptions.CityNotFoundException;
import com.sapient.bookmyshow.exceptions.ResourceNotFoundException;
import com.sapient.bookmyshow.models.*;
import com.sapient.bookmyshow.repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class HallService {
    private SeatService seatService;
    private HallRepository hallRepository;

    public static List<Seat> toSeats(Hall hall, Map<SeatType, List<SeatPosition>> seatPositions) {

        return seatPositions.entrySet().stream().flatMap(entry -> {

            SeatType seatType = entry.getKey();
            List<SeatPosition> positions = entry.getValue();

            return positions
                    .stream()
                    .map(seatPosition ->
                            Seat.builder()
                                    .seatType(seatType)
                                    .rowNo(seatPosition.getRowNo())
                                    .columnNo(seatPosition.getColumnNo())
                                    .hall(hall)
                                    .build());
        }).toList();
    }

    public Hall createHall(CreateHallRequest request) {

        Hall hallRequest = Hall.builder()
                .name(request.getName())
                .features(request.getFeatures())
                .isDeleted(false)
                .build();
        Hall initialHall = hallRepository.save(hallRequest);

        List<Seat> seats = toSeats(initialHall, request.getSeatRanges());
        List<Seat> savedSeats = seatService.saveAll(seats);

        //return hallRepository.save(initialHall.toBuilder().seats(savedSeats).build());
        //return hallRepository.findById(initialHall.getId()).orElse(null);
        return getHall(initialHall.getId());
    }

    public Hall getHall(Long id) {
        //return hallRepository.findById(id).orElse(null);
        return hallRepository.findHallByIdAndIsDeletedFalse(id).orElse(null);
    }

    public List<Hall> getHalls(List<Long> ids) {
        //return hallRepository.findAllById(ids);
        return hallRepository.findAllByIdInAndIsDeletedFalse(ids);
    }

    public Hall deleteHall(Long id) {
        Hall existingHall = hallRepository.findHallByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found"));

        existingHall.setIsDeleted(true);

        return hallRepository.save(existingHall);
    }

    public Hall updateHall(Long id, CreateHallRequest request) {
        Hall existingHall = hallRepository.findHallByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with ID " + id + " not found"));

        seatService.deleteByHallId(existingHall.getId());

        existingHall.setName(request.getName());
        existingHall.setFeatures(request.getFeatures());

        Hall initialHall = hallRepository.save(existingHall);

        List<Seat> seats = toSeats(initialHall, request.getSeatRanges());
        List<Seat> savedSeats = seatService.saveAll(seats);

        return getHall(initialHall.getId());
    }
}
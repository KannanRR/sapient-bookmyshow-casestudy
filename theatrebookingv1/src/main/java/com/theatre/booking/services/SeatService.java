package com.theatre.booking.services;

import com.theatre.booking.models.Seat;
import com.theatre.booking.repositories.SeatRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private SeatRepository seatRepository;

    public List<Seat> saveAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }

    public List<Seat> getAll(Long hallId) {
        return seatRepository.findAllByHall_Id(hallId);
    }

    @Transactional
    public List<Seat> deleteByHallId(Long id) {
        return seatRepository.deleteByHallId(id);
    }
}
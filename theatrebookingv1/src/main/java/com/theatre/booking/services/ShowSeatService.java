package com.theatre.booking.services;

import com.theatre.booking.models.ShowSeat;
import com.theatre.booking.repositories.ShowSeatRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {
    private ShowSeatRepository showSeatRepository;

    public List<ShowSeat> saveAll(List<ShowSeat> showSeats) {
        return showSeatRepository.saveAll(showSeats);
    }

    public List<ShowSeat> getShowSeats(List<Long> showSeatIds) {
        return showSeatRepository.findAllById(showSeatIds);
    }

    @Transactional
    public List<ShowSeat> deleteByShowId(Long id) {
        return showSeatRepository.deleteByShowId(id);
    }
}
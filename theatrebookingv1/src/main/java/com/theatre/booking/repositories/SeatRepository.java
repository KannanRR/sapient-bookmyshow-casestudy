package com.theatre.booking.repositories;

import com.theatre.booking.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    public List<Seat> findAllByHall_Id(Long id);

    public List<Seat> deleteByHallId(Long id);
}
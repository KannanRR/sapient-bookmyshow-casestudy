package com.theatre.booking.repositories;

import com.theatre.booking.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    Optional<Theatre> findTheatreByIdAndIsDeletedFalse(Long id);
}
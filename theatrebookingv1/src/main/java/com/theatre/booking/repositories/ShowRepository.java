package com.theatre.booking.repositories;

import com.theatre.booking.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findShowByIdAndIsDeletedFalse(Long id);

    Optional<Show> findShowByIdAndIsOnlineTrueOrIsDeletedFalse(Long id);
}
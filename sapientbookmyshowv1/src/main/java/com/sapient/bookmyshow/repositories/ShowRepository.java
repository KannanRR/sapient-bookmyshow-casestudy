package com.sapient.bookmyshow.repositories;

import com.sapient.bookmyshow.models.Movie;
import com.sapient.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findShowByIdAndIsDeletedFalse(Long id);

    Optional<Show> findShowByIdAndIsOnlineTrueOrIsDeletedFalse(Long id);
}
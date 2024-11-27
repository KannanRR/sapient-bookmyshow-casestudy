package com.theatre.booking.repositories;

import com.theatre.booking.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByIdAndIsDeletedFalse(Long id);
    //List<Movie> findByNameContaining(String name);

    List<Movie> findByNameContainingAndIsDeletedFalse(String name);

    // Find movies where shows are between specific dates
    @Query("SELECT m FROM Movie m INNER JOIN m.shows s WHERE s.startDate = :startDate AND m.id = :movieId AND m.isDeleted=false")
    Movie findMoviesByShowStartDate(@Param("startDate") LocalDate startDate, @Param("movieId") Long movieId);

    //Movie findByIdAndShowsStartDate(Long id, LocalDate startDate);
}
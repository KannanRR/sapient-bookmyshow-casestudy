package com.sapient.bookmyshow.repositories;

import com.sapient.bookmyshow.models.Hall;
import com.sapient.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    Optional<Hall> findHallByIdAndIsDeletedFalse(Long id);

    List<Hall> findAllByIdInAndIsDeletedFalse(List<Long> ids);
}
package com.sapient.bookmyshow.repositories;

import com.sapient.bookmyshow.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    //List<City> findByNameContaining(String name);
    List<City> findByNameContainingAndIsDeletedFalse(String name);

    Optional<City> findCityByIdAndIsDeletedFalse(Long id);

    List<City> findAllByIsDeletedFalse();
}

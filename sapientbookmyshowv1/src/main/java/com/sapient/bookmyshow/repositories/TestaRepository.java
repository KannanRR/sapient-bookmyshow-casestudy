package com.sapient.bookmyshow.repositories;

import com.sapient.bookmyshow.models.Testa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestaRepository extends JpaRepository<Testa, Long> {
}

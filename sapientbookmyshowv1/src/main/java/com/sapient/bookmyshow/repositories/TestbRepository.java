package com.sapient.bookmyshow.repositories;

import com.sapient.bookmyshow.models.Testb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestbRepository extends JpaRepository<Testb, Long> {
}

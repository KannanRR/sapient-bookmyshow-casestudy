package com.sapient.bookmyshow.services;

import com.sapient.bookmyshow.exceptions.CityNotFoundException;
import com.sapient.bookmyshow.models.Testa;
import com.sapient.bookmyshow.repositories.TestaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestaService {
    private TestaRepository testaRepository;
    public Testa createTesta(Testa request) {
        return testaRepository.save(request);
    }

    public Testa getTesta(Long id) {
        return testaRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public List<Testa> getallTesta() {
        return testaRepository.findAll();
    }
}

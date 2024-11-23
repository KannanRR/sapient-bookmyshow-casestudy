package com.sapient.bookmyshow.services;

import com.sapient.bookmyshow.dtos.CreateTestbRequest;
import com.sapient.bookmyshow.models.Testa;
import com.sapient.bookmyshow.models.Testb;
import com.sapient.bookmyshow.repositories.TestbRepository;
import com.sapient.bookmyshow.exceptions.CityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestbService {
    private TestbRepository testbRepository;
    private TestaService testaService;
    public Testb createTestb(CreateTestbRequest request) {

        Testa testa = testaService.getTesta(request.getTestaid());
        Testb testb = testbRepository.save(Testb.builder().bname(request.getBname())
                .testa(testa).build());

        return getTestb(testb.getId());
    }

    public Testb getTestb(Long id) {
        return testbRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public List<Testb> getallTestb() {
        return testbRepository.findAll();
    }
}

package com.sapient.bookmyshow.controllers;

import com.sapient.bookmyshow.dtos.CreateTestbRequest;
import com.sapient.bookmyshow.models.Testb;
import com.sapient.bookmyshow.services.TestbService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testb")
@AllArgsConstructor
public class TestbController {

    private TestbService testbService;

    @PostMapping
    public Testb createTestb(@RequestBody CreateTestbRequest request) {
        return testbService.createTestb(request);
    }

    @GetMapping("/{id}")
    public Testb getTestb(@PathVariable Long id) {
        return testbService.getTestb(id);
    }

    @GetMapping("/all")
    public List<Testb> getallTestb() {
        return testbService.getallTestb();
    }
}

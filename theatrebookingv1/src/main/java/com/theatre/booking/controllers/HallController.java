package com.theatre.booking.controllers;

import com.theatre.booking.dtos.CreateHallRequest;
import com.theatre.booking.models.Hall;
import com.theatre.booking.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hall")
@AllArgsConstructor
public class HallController {

    private HallService hallService;
    @PostMapping
    public Hall createHall(@RequestBody CreateHallRequest request) {
        return hallService.createHall(request);
    }

    @GetMapping("/{id}")
    public Hall getHall(@PathVariable Long id) {
        return hallService.getHall(id);
    }

    @PutMapping("/{id}")
    public Hall updateHall(@PathVariable Long id, @RequestBody CreateHallRequest request) {
        return hallService.updateHall(id, request);
    }

    @DeleteMapping("/{id}")
    public Hall deleteHall(@PathVariable Long id) {
        return hallService.deleteHall(id);
    }
}

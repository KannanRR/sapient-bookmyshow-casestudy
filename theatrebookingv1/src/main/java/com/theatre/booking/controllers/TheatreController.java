package com.theatre.booking.controllers;

import com.theatre.booking.dtos.CreateTheatreRequest;
import com.theatre.booking.models.Theatre;
import com.theatre.booking.services.TheatreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
@AllArgsConstructor
public class TheatreController {

    private TheatreService theatreService;
    @PostMapping
    public Theatre createTheatre(@RequestBody CreateTheatreRequest request) {
        return theatreService.createTheatre(request);
    }

    @GetMapping("/{id}")
    public Theatre getTheatrebyId(@PathVariable Long id) {
        return theatreService.getTheatre(id);
    }

    @DeleteMapping("/{id}")
    public Theatre deleteTheatre(@PathVariable Long id) {
        return theatreService.deleteTheatre(id);
    }

    @PutMapping("/{id}")
    public Theatre updateMovie(@PathVariable Long id, @RequestBody CreateTheatreRequest request) {
        return theatreService.updateTheatre(id, request);
    }

}

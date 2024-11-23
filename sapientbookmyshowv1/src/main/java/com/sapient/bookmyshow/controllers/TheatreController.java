package com.sapient.bookmyshow.controllers;

import com.sapient.bookmyshow.dtos.CreateMovieRequest;
import com.sapient.bookmyshow.dtos.CreateTheatreRequest;
import com.sapient.bookmyshow.models.Movie;
import com.sapient.bookmyshow.models.Theatre;
import com.sapient.bookmyshow.services.TheatreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

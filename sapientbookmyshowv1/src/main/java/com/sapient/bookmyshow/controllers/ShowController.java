package com.sapient.bookmyshow.controllers;

import com.sapient.bookmyshow.dtos.CreateMovieRequest;
import com.sapient.bookmyshow.dtos.CreateShowRequest;
import com.sapient.bookmyshow.models.Movie;
import com.sapient.bookmyshow.models.Show;
import com.sapient.bookmyshow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    // READ API for show
    @GetMapping("/show/{id}")
    public Show readShow(@PathVariable Long id) {
        return showService.getShow(id);
    }

    // CREATE SHOW API
    @PostMapping("/show")
    public Show createShow(@RequestBody CreateShowRequest request) {
        return showService.createShow(request);
    }

    @PutMapping("/show/{id}")
    public Show updateShow(@PathVariable Long id, @RequestBody CreateShowRequest request) {
        return showService.updateShow(id, request);
    }

    @DeleteMapping("/show/{id}")
    public Show deleteShow(@PathVariable Long id) {
        return showService.deleteShow(id);
    }
}
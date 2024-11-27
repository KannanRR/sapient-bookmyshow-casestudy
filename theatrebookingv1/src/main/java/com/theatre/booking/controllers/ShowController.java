package com.theatre.booking.controllers;

import com.theatre.booking.dtos.CreateShowRequest;
import com.theatre.booking.models.Show;
import com.theatre.booking.services.ShowService;
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
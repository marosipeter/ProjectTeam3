package com.teamthree.event.controller;

import com.teamthree.event.dto.EventViewDto;
import com.teamthree.event.service.EventServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    private final EventServiceImpl eventService;

    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/")
    public List<EventViewDto> getAll() {

        return eventService.getAll();
    }

    /*@GetMapping(value = "/country")
    public List<EventViewDto> getAllByCountry() {

        return eventService.getAllByCountry();
    }*/
}

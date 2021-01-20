package com.teamthree.event.controller;

import com.teamthree.event.dto.EventViewDto;
import com.teamthree.event.service.EventServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    private final EventServiceImpl eventService;

    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/")
    public List<EventViewDto> getAll() {

        return eventService.getAll();
    }

    @GetMapping(value = "/Type")
    public List<EventViewDto> getEventsByType(@RequestParam("eventType") String eventType) {
        return eventService.getEventsByType(eventType);
    }

    @GetMapping(value = "/Price")
    public List<EventViewDto> getEventsByPrice(@RequestParam("eventPrice1") Double price) {
        return eventService.getEventsByPrice(price);
    }

}

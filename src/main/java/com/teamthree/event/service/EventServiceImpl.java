package com.teamthree.event.service;

import com.teamthree.event.domain.Type;
import com.teamthree.event.dto.EventViewDto;
import com.teamthree.event.repository.EventRepository;
import com.teamthree.event.service.EventService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.teamthree.event.domain.Type.CONCERT;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventViewDto> getAll() {
        List<EventViewDto> eventList = new ArrayList<>();
        eventRepository.findAll()
                // User -> UserViewDto -> add to a LIST
                .forEach(event -> eventList.add(new EventViewDto(event.getId(),event.getName(), event.getDescription(), event.getAddress(), event.getDate(), event.getEventType())));

        return eventList;
    }

   /* @Override
    public List<EventViewDto> getAllByCountry() {
        List<EventViewDto> eventList = new ArrayList<>();
        //eventRepository.findAll()
                //.forEach(event -> eventList.add(new EventViewDto(event.getId(),event.getName(), event.getDescription(), event.getAddress(), event.getDate(), event.getEventType())));
        //eventRepository.findAll()
                //.forEach(event -> eventList.add(new EventViewDto(event.getId(),event.getName(), event.getDescription(), event.getAddress(), event.getDate(), event.getEventType())));
        List<EventViewDto> newEventList = eventList.stream()
                .filter(event -> event.getEventType().equals(CONCERT))
                .collect(Collectors.toList());
        //eventRepository.findAll()
                // User -> UserViewDto -> add to a LIST
                //.forEach(event -> newEventList.add(new EventViewDto(event.getId(),event.getName(), event.getDescription(), event.getAddress(), event.getDate(), event.getEventType())));

        return newEventList;
    }*/

}

package com.teamthree.event.service;

import com.teamthree.event.domain.Event;
import com.teamthree.event.domain.EventType;
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
                .forEach(event -> eventList.add(new EventViewDto(event.getId(),event.getName(), event.getDescription(), event.getAddress(), event.getDate(), event.getEventType(), event.getTicketPrice())));

        return eventList;
    }

    /*public List<EventViewDto> getEventsByType(String type) {
       EventType eventType = new EventType();
       eventType.setType(Type.valueOf(type));
        List<EventViewDto> newEventList = new ArrayList<>();
                //.forEach(event -> newEventList.add(new EventViewDto(event.getId(),event.getName(), event.getDescription(), event.getAddress(), event.getDate(), event.getEventType())));
        List<EventViewDto> events = eventRepository.findEventByType();
        for (final EventViewDto eventViewDto : events) {
            // Here your room is available
        }
        return newEventList;
    }*/

    public List<EventViewDto> getEventsByType(String type) {
        EventType eventType = new EventType();
        eventType.setType(Type.valueOf(type));
        List<EventViewDto> eventList = getAll();
        List<EventViewDto> newEventList = new ArrayList<>();
        for (final EventViewDto eventViewDto : eventList) {
          if (eventViewDto.getEventType().equals(eventType)){
              newEventList.add(eventViewDto);
          }
        }

     return newEventList;
    }

    public List<EventViewDto> getEventsByPrice(Double price) {
        Event eventPrice = new Event();
        eventPrice.setTicketPrice(price);
        List<EventViewDto> eventList1 = getAll();
        List<EventViewDto> newEventList1 = new ArrayList<>();
        for (final EventViewDto eventViewDto1 : eventList1) {
            if (eventViewDto1.getTicketPrice()==price){
                newEventList1.add(eventViewDto1);
            }
        }

        return newEventList1;
    }

}

package com.teamthree.event.service.impl;

import com.teamthree.event.domain.Event;
import com.teamthree.event.domain.Ticket;
import com.teamthree.event.domain.User;
import com.teamthree.event.dto.TicketInsertDto;
import com.teamthree.event.dto.TicketViewDto;
import com.teamthree.event.repository.EventRepository;
import com.teamthree.event.repository.TicketRepository;
import com.teamthree.event.repository.UserRepository;
import com.teamthree.event.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, EventRepository eventRepository, UserRepository userRepository) {

        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void buy(TicketInsertDto ticketInsertDto) { //eventID and userID

        Iterable<Event> events = eventRepository.findAll();
        Event eventToSave = new Event();
        User userToSave = new User();
        for (Event event : events) {
            Long eventIdToCompare = event.getId();
            if (eventIdToCompare == ticketInsertDto.getEventId()) {

                eventToSave = event;

                Iterable<User> users = userRepository.findAll();
                for (User user : users) {
                    Long userIdToCompare = user.getId();
                    if (userIdToCompare == ticketInsertDto.getUserId()) {

                        userToSave = user;
                    }
                }
            }
        }

        Ticket ticket = new Ticket();

        ticket.setEvent(eventToSave);
        ticket.setUser(userToSave);

        ticketRepository.save(ticket);

        updateSoldTicketNumber(ticketInsertDto.getEventId());
    }

    @Override
    public List<TicketViewDto> getAll() {
        List<TicketViewDto> ticketList = new ArrayList<>();
        Iterable<Ticket> tickets = ticketRepository.findAll();
        for (Ticket ticket : tickets)
        {
            TicketViewDto ticketViewDto = TicketViewDto.toTicketViewDto(ticket);
            ticketList.add(ticketViewDto);
        }
        return ticketList;
    }

    public void updateSoldTicketNumber (long eventId) {

        Event event = eventRepository.findById(eventId);
        event.setSoldTicketNumber(event.getSoldTicketNumber() + 1);
        eventRepository.save(event);
    }
}

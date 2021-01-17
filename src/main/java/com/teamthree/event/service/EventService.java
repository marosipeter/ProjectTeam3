package com.teamthree.event.service;

import com.teamthree.event.domain.Event;
import com.teamthree.event.dto.EventViewDto;

import java.util.List;

public interface EventService {
    List<EventViewDto> getAll();
    //List<EventViewDto> getAllByCountry();
}

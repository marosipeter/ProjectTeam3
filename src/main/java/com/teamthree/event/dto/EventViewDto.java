package com.teamthree.event.dto;

import com.teamthree.event.domain.Address;
import com.teamthree.event.domain.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class EventViewDto {

    private Long id;
    private String name;
    private String description;
    private Address address;
    private LocalDateTime date;
    private EventType eventType;


    public EventType getEventType() {
        return eventType;
    }
}

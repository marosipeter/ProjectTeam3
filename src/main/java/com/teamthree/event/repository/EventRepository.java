package com.teamthree.event.repository;

import com.teamthree.event.domain.Event;
import com.teamthree.event.domain.EventType;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

    //public EventType getEventType();
}

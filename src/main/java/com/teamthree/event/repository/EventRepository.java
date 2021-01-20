package com.teamthree.event.repository;

import com.teamthree.event.domain.Event;
import com.teamthree.event.domain.EventType;
import com.teamthree.event.dto.EventViewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long>, JpaRepository<Event, Long> {

    /**
     * Finds a person by using the last name as a search criteria.
     * @param eventType
     * @return  A list of persons whose last name is an exact match with the given last name.
     *          If no persons is found, this method returns an empty list.
     */
    @Query(
            value = "SELECT * FROM events",
            nativeQuery = true)
    public List<EventViewDto> findEventByType();

    Event findById(long id);

}

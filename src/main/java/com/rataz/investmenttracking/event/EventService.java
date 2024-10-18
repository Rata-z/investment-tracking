package com.rataz.investmenttracking.event;

import java.util.Optional;

public interface EventService {

    Iterable<Event> getAllEvents();

    Optional<Event> getEventById(Long id);

    Boolean deleteEvent(Long id);

    Event addEvent(Event event);

}

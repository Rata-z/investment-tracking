package com.rataz.investmenttracking.event;

import com.rataz.investmenttracking.coupon.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Boolean deleteEvent(Long id) {
        Optional<Event> deletedEvent = eventRepository.findById(id);
        if (deletedEvent.isPresent()) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
}

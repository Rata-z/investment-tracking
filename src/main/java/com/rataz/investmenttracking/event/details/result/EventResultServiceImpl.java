package com.rataz.investmenttracking.event.details.result;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventResultServiceImpl implements EventResultService {

    EventResultRepository eventResultRepository;

    public EventResultServiceImpl(EventResultRepository eventResultRepository) {
        this.eventResultRepository = eventResultRepository;
    }


    @Override
    public Iterable<EventResult> getAllEventsResults() {
        return eventResultRepository.findAll();
    }

    @Override
    public Optional<EventResult> getEventResultById(Long id) {
        return eventResultRepository.findById(id);
    }

    @Override
    public EventResult addEventResult(EventResult eventResult) {
        return eventResultRepository.save(eventResult);
    }

    @Override
    public Boolean deleteEventResult(Long id) {
        Optional<EventResult> deletedEventResult = eventResultRepository.findById(id);
        if (deletedEventResult.isPresent()) {
            eventResultRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

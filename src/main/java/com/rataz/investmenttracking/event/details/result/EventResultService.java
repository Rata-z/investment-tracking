package com.rataz.investmenttracking.event.details.result;

import java.util.Optional;

public interface EventResultService {
    Iterable<EventResult> getAllEventsResults();

    Optional<EventResult> getEventResultById(Long id);

    EventResult addEventResult(EventResult eventResult);

    Boolean deleteEventResult(Long id);
}

package com.rataz.investmenttracking.event.details.result;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/events/details/results")
public class EventResultController {
    EventResultService eventResultService;

    public EventResultController(EventResultService eventResultService) {
        this.eventResultService = eventResultService;
    }

    @GetMapping
    public Iterable<EventResult> getEventsResults() {
        return eventResultService.getAllEventsResults();

    }

    @GetMapping("/{id}")
    public Optional<EventResult> getEventResultById(@PathVariable Long id) {
        return eventResultService.getEventResultById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResult addEventResult(EventResult eventResult) {
        return eventResultService.addEventResult(eventResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEventResult(@PathVariable Long id) {
        boolean deleted = eventResultService.deleteEventResult(id);
        HttpStatus status = deleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }
}

package com.rataz.investmenttracking.event.details.statistic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/events/details/statistics")
public class EventStatisticController {
    EventStatisticService eventStatisticService;

    public EventStatisticController(EventStatisticService eventStatisticService) {
        this.eventStatisticService = eventStatisticService;
    }

    @GetMapping
    public Iterable<EventStatistic> getEventsStatistics() {
        return eventStatisticService.getAllEventsStatistics();

    }

    @GetMapping("/{id}")
    public Optional<EventStatistic> getEventStatisticById(@PathVariable Long id) {
        return eventStatisticService.getEventStatisticById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventStatistic addEventStatistic(EventStatistic eventStatistic) {
        return eventStatisticService.addEventStatistic(eventStatistic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEventStatistic(@PathVariable Long id) {
        boolean deleted = eventStatisticService.deleteEventStatistic(id);
        HttpStatus status = deleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }
}

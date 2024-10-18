package com.rataz.investmenttracking.event.details.statistic;

import java.util.Optional;

public interface EventStatisticService {
    Iterable<EventStatistic> getAllEventsStatistics();

    Optional<EventStatistic> getEventStatisticById(Long id);

    EventStatistic addEventStatistic(EventStatistic eventStatistic);

    Boolean deleteEventStatistic(Long id);
}

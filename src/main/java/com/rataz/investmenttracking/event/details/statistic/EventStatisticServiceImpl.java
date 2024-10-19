package com.rataz.investmenttracking.event.details.statistic;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventStatisticServiceImpl implements EventStatisticService {
    EventStatisticRepository eventStatisticRepository;

    public EventStatisticServiceImpl(EventStatisticRepository eventStatisticRepository) {
        this.eventStatisticRepository = eventStatisticRepository;
    }

    @Override
    public Iterable<EventStatistic> getAllEventsStatistics() {
        return eventStatisticRepository.findAll();
    }

    @Override
    public Optional<EventStatistic> getEventStatisticById(Long id) {
        return eventStatisticRepository.findById(id);
    }

    @Override
    public EventStatistic addEventStatistic(EventStatistic eventStatistic) {
        return eventStatisticRepository.save(eventStatistic);
    }

    @Override
    public Boolean deleteEventStatistic(Long id) {
        Optional<EventStatistic> deletedEventStatistic = eventStatisticRepository.findById(id);
        if (deletedEventStatistic.isPresent()) {
            eventStatisticRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

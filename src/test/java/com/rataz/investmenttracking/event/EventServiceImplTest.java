package com.rataz.investmenttracking.event;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    private Event event;

    @BeforeEach
    public void init() {
        event = Event.builder().isWon(false).liveBet(true).odds(BigDecimal.valueOf(2.00)).eventType(null).build();
    }

    @Test
    void eventService_getEventById_returnsEvent() {
        when(eventRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(event));
        Optional<Event> result = eventService.getEventById(1L);
        Assertions.assertThat(result).isPresent();
    }

    @Test
    void eventService_getEventById_returnsEmpty() {
        when(eventRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        Optional<Event> result = eventService.getEventById(1L);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    void eventService_deleteEvent_returnsTrue() {
        when(eventRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(event));
        boolean result = eventService.deleteEvent(1L);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void eventService_deleteEvent_returnsFalse() {
        when(eventRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        boolean result = eventService.deleteEvent(1L);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void addEvent() {
        when(eventRepository.save(any(Event.class))).thenReturn(event);
        Event result = eventService.addEvent(event);
        assertEquals(result, event);

    }
}
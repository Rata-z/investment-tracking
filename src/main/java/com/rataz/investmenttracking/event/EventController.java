package com.rataz.investmenttracking.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping("/")
    public List<Event> getAll2(){
        return eventRepository.findAll();

    }
}

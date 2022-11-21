package com.martweb.ticketful.api.controllers;

import com.martweb.ticketful.api.dtos.CreateEventRequest;
import com.martweb.ticketful.api.dtos.UpdateEventRequest;
import com.martweb.ticketful.api.entities.Event;
import com.martweb.ticketful.api.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        var events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id){
        var event = eventService.getEventById(id);
        return ResponseEntity.of(event);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewEvent(@RequestBody CreateEventRequest createEventRequest) throws ParseException {
        var newEvent = eventService.createNewEvent(createEventRequest);
        return ResponseEntity.status(201).body(newEvent);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody UpdateEventRequest updateEventRequest) throws ParseException {
        var updateEvent = eventService.updateEvent(id, updateEventRequest);
        return ResponseEntity.of(updateEvent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<Object,Object>> deleteEvent(@PathVariable Long id){
        var validate = eventService.deleteEvent(id);
        return ResponseEntity.ok(validate);
    }
}

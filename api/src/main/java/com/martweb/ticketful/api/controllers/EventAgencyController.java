package com.martweb.ticketful.api.controllers;

import com.martweb.ticketful.api.dtos.CreateEventAgencyRequest;
import com.martweb.ticketful.api.dtos.UpdateEventAgencyRequest;
import com.martweb.ticketful.api.entities.EventAgency;
import com.martweb.ticketful.api.services.EventAgencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/eventagencies")
public class EventAgencyController {
    private final EventAgencyService eventAgencyService;

    public EventAgencyController(EventAgencyService eventAgencyService) {
        this.eventAgencyService = eventAgencyService;
    }
    @GetMapping
    public ResponseEntity<List<EventAgency>> getAllEventAgencies(){
        var eventAgencies = eventAgencyService.getAllEventAgencies();
        return ResponseEntity.ok(eventAgencies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventAgency> getEventAgencyById(@PathVariable Long id){
        var getEventAgency = eventAgencyService.getEventAgencyById(id);
        return ResponseEntity.of(getEventAgency);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewEventAgency(@RequestBody CreateEventAgencyRequest createEventAgencyRequest){
        var entityAgency = eventAgencyService.createNewEventAgency(createEventAgencyRequest);
        return ResponseEntity.status(201).body(entityAgency);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EventAgency> updateEventAgency(@PathVariable Long id, @RequestBody UpdateEventAgencyRequest updateEventAgencyRequest){
        var eventAgency = eventAgencyService.updateEventAgency(id, updateEventAgencyRequest);
        return ResponseEntity.of(eventAgency);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<Object, Object>> deleteEventAgency(@PathVariable Long id){
        var validate = eventAgencyService.deleteEventAgency(id);
        return ResponseEntity.ok(validate);
    }

}

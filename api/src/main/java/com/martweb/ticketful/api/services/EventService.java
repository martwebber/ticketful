package com.martweb.ticketful.api.services;

import com.martweb.ticketful.api.dtos.CreateEventRequest;
import com.martweb.ticketful.api.dtos.UpdateEventRequest;
import com.martweb.ticketful.api.entities.Event;
import com.martweb.ticketful.api.entities.EventAgency;
import com.martweb.ticketful.api.repositories.EventAgencyRepository;
import com.martweb.ticketful.api.repositories.EventRepository;
import com.martweb.ticketful.api.utils.DateFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventAgencyRepository eventAgencyRepository;


    public EventService(EventRepository eventRepository, EventAgencyRepository eventAgencyRepository) {
        this.eventRepository = eventRepository;
        this.eventAgencyRepository = eventAgencyRepository;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id){
        var event = eventRepository.findById(id);
        if(event.isEmpty()){
            System.out.println("Event not found");
        }
        return event;
    }
    public Event createNewEvent(CreateEventRequest createEventRequest) throws ParseException {
        var newEvent = new Event();
        var eventAgency = eventAgencyRepository.findById(createEventRequest.getEventAgencyId()).orElseThrow(()->{
            new Exception("Agency not found");
            return null;
        });
//        eventAgency.ifPresentOrElse(newEvent::setEventAgency,()->{
//            System.out.println("Event agency not found");
//        });
        newEvent.setEventTitle(createEventRequest.getEventTitle());
        newEvent.setEventDescription(createEventRequest.getEventDescription());
        newEvent.setEventVenue(createEventRequest.getEventVenue());
        newEvent.setEventBanner(createEventRequest.getEventBanner());
        newEvent.setDate(DateFormat.dateFormatter(createEventRequest.getDate()));
        newEvent.setEventAgency(eventAgency);
        eventRepository.save(newEvent);
        return newEvent;
    }

    public Optional<Event> updateEvent(Long id, UpdateEventRequest updateEventRequest){
        var updateEvent = eventRepository.findById(id).get();
        var eventAgency = eventAgencyRepository.findById(updateEventRequest.getEventAgencyId());
        eventAgency.ifPresentOrElse(ue->{
            updateEvent.setEventAgency(ue);
        },()->{
            System.out.println("Event agency not found");
        });
        if(updateEvent==null){
            System.out.println("Event does not exist");
        }
        updateEvent.setEventTitle(updateEventRequest.getEventTitle());
        updateEvent.setEventDescription(updateEventRequest.getEventDescription());
        updateEvent.setEventVenue(updateEventRequest.getEventVenue());
        updateEvent.setEventBanner(updateEventRequest.getEventBanner());
            try {
                updateEvent.setDate(DateFormat.dateFormatter(updateEventRequest.getDate()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            eventRepository.save(updateEvent);
        return Optional.of(updateEvent);
    }

    public HashMap<Object,Object> deleteEvent(Long id){
        var validate = new HashMap<>();
        var eventToDelete = eventRepository.findById(id);
        eventToDelete.ifPresentOrElse(eve->{
            eventRepository.delete(eve);
            validate.put("message", "Event deleted");
        },()->{
            System.out.println("Event not found");
        });
        return validate;
    }
}

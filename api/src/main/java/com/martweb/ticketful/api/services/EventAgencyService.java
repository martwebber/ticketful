package com.martweb.ticketful.api.services;

import com.martweb.ticketful.api.dtos.CreateEventAgencyRequest;
import com.martweb.ticketful.api.dtos.UpdateEventAgencyRequest;
import com.martweb.ticketful.api.entities.EventAgency;
import com.martweb.ticketful.api.repositories.EventAgencyRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EventAgencyService {
    private final EventAgencyRepository eventAgencyRepository;

    public EventAgencyService(EventAgencyRepository eventAgencyRepository) {
        this.eventAgencyRepository = eventAgencyRepository;
    }

    public List<EventAgency> getAllEventAgencies(){
        return eventAgencyRepository.findAll();
    }

    public Optional<EventAgency> getEventAgencyById(Long id){
        var eventAgency = eventAgencyRepository.findById(id);
        return eventAgency;
    }
    public EventAgency createNewEventAgency(CreateEventAgencyRequest createEventAgencyRequest){
        var newEventAgency = new EventAgency();
        newEventAgency.setEventAgencyName(createEventAgencyRequest.getEventAgencyName());
        newEventAgency.setUserId(createEventAgencyRequest.getUserId());
        newEventAgency.setEventAgencyDescription(createEventAgencyRequest.getEventAgencyDescription());
        newEventAgency.setAddress(createEventAgencyRequest.getAddress());
        newEventAgency.setVerified(createEventAgencyRequest.getVerified());
        eventAgencyRepository.save(newEventAgency);
        return newEventAgency;
    }

    public Optional<EventAgency> updateEventAgency(Long id, UpdateEventAgencyRequest updateEventAgencyRequest){
        var eventAgency = eventAgencyRepository.findById(id);
        eventAgency.ifPresentOrElse(e->{
            e.setEventAgencyName(updateEventAgencyRequest.getEventAgencyName());
            e.setEventAgencyDescription(updateEventAgencyRequest.getEventAgencyDescription());
            e.setAddress(updateEventAgencyRequest.getAddress());
            e.setUserId(updateEventAgencyRequest.getUserId());
            e.setVerified(updateEventAgencyRequest.getVerified());
            eventAgencyRepository.save(e);
        },()->{
            System.out.println("Event agency not found");
        });
        return eventAgency;
    }

    public HashMap<Object, Object> deleteEventAgency(Long id){
        var validate = new HashMap<>();
        var eventAgency = eventAgencyRepository.findById(id);
        eventAgency.ifPresentOrElse(eAgency->{
            eventAgencyRepository.delete(eAgency);
            validate.put("message","Event agency deleted successfully ✅");
        },()->{
            System.out.println("Even agency not found");
        });
        return validate;
    }
}

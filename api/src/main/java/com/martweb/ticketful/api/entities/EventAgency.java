package com.martweb.ticketful.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "eventagencies")
public class EventAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String eventAgencyName;
    private String eventAgencyDescription;
    private String address;
    @JsonIgnore
    @OneToMany(mappedBy = "eventAgency")
//    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private List<Event> events;
//    private Set<Event> events = new HashSet<>();
    private Boolean verified = false;

//    public void setEvents(Set<Event> events) {
//        this.events = events;
//    }
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEventAgencyName() {
        return eventAgencyName;
    }

    public void setEventAgencyName(String eventAgencyName) {
        this.eventAgencyName = eventAgencyName;
    }

    public String getEventAgencyDescription() {
        return eventAgencyDescription;
    }

    public void setEventAgencyDescription(String eventAgencyDescription) {
        this.eventAgencyDescription = eventAgencyDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

//    public Set<Event> getEvents() {
//        return events;
//    }
}

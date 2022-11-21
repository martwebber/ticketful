package com.martweb.ticketful.api.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventTitle;
    private String eventDescription;
    private String eventVenue;
    private String eventBanner;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm")
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_agency_id", referencedColumnName = "id")
    private EventAgency eventAgency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventBanner() {
        return eventBanner;
    }

    public void setEventBanner(String eventBanner) {
        this.eventBanner = eventBanner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public EventAgency getEventAgency() {
        return eventAgency;
    }

    public void setEventAgency(EventAgency eventAgencyId) {
        this.eventAgency = eventAgency;
    }
}

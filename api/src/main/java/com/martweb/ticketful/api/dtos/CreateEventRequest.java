package com.martweb.ticketful.api.dtos;


public class CreateEventRequest {
    private String eventTitle;
    private String eventDescription;
    private String eventVenue;
    private String eventBanner;
    private String date;
    private Long eventAgencyId;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getEventAgencyId() {
        return eventAgencyId;
    }

    public void setEventAgencyId(Long eventAgencyId) {
        this.eventAgencyId = eventAgencyId;
    }
}

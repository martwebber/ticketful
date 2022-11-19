package com.martweb.ticketful.api.dtos;

public class UpdateEventAgencyRequest {
    private Long userId;
    private String eventAgencyName;
    private String eventAgencyDescription;
    private String address;
    private Boolean verified;

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
}

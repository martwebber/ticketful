package com.martweb.ticketful.api.dtos;

import javax.validation.constraints.NotBlank;

public class CreateRoleRequest {
//    @NotBlank(message = "Name cannot be blank")
    private String name;
//    @NotBlank(message = "Description cannot be blankR")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

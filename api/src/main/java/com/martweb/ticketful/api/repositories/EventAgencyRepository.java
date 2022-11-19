package com.martweb.ticketful.api.repositories;

import com.martweb.ticketful.api.entities.EventAgency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventAgencyRepository extends JpaRepository<EventAgency, Long> {
    Optional<EventAgency> findByEventAgencyName(String eventAgencyName);
}

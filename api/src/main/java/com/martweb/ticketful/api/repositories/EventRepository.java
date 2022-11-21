package com.martweb.ticketful.api.repositories;

import com.martweb.ticketful.api.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

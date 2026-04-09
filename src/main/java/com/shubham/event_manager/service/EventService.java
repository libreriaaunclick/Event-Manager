package com.shubham.event_manager.service;

import com.shubham.event_manager.dto.EventDTO;
import java.util.List;

public interface EventService {
    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long id);

    EventDTO createEvent(EventDTO event);

    EventDTO updateEvent(Long id, EventDTO event);

    void deleteEvent(Long id);
}

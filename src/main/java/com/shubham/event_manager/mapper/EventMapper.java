package com.shubham.event_manager.mapper;

import com.shubham.event_manager.dto.EventDTO;
import com.shubham.event_manager.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDTO toDTO(Event event) {
        if (event == null) return null;
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setEventDate(event.getEventDate());
        dto.setLocation(event.getLocation());
        dto.setCapacity(event.getCapacity());
        dto.setCreatedAt(event.getCreatedAt());
        return dto;
    }

    public Event toEntity(EventDTO dto) {
        if (dto == null) return null;
        Event event = new Event();
        event.setId(dto.getId());
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());
        event.setCapacity(dto.getCapacity());
        return event;
    }

    public void updateEntityFromDTO(EventDTO dto, Event event) {
        if (dto == null) return;
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());
        event.setCapacity(dto.getCapacity());
    }
}
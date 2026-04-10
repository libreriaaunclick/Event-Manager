package com.shubham.event_manager.mapper;


import com.shubham.event_manager.dto.EventDTO;
import com.shubham.event_manager.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDTO toDTO(Event event);

    Event toEntity(EventDTO eventDTO);

    void updateEntityFromDTO(EventDTO eventDTO, @MappingTarget Event event);
}

package com.shubham.event_manager.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    private Long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    private String description;

    @NotNull(message = "Event date cannot be empty")
    @Future(message = "Event date cannot be in the past")
    private LocalDateTime eventDate;

    private String location;

    @Min(value = 1, message = "Capacity cannot be less than 1")
    private Integer capacity;

}

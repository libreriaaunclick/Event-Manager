package com.shubham.event_manager.controller;

import com.shubham.event_manager.service.AiRecommendationService;
import com.shubham.event_manager.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
@Tag(name = "AI Recommendations",
        description = "Smart event recommendations")
public class AiController {

    private final AiRecommendationService aiService;
    private final EventService eventService;

    @GetMapping("/recommend")
    @Operation(
            summary = "Get AI event recommendations",
            description = "Tell us your interests, get personalized event suggestions",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> recommend(
            @RequestParam String interests) {
        String recommendations = aiService.getRecommendations(
                interests,
                eventService.getAllEvents()
        );
        return ResponseEntity.ok(recommendations);
    }
}

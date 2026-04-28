package com.shubham.event_manager.service;

import com.shubham.event_manager.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AiRecommendationService {

    private final ChatClient chatClient;

    public String getRecommendations(String userInterests,
                                     List<EventDTO> availableEvents) {
        String eventList = availableEvents.stream()
                .map(e -> "- " + e.getTitle()
                        + " in " + e.getLocation()
                        + " on " + e.getEventDate())
                .collect(Collectors.joining("\n"));

        String prompt = """
                You are an event recommendation assistant.
                
                User interests: %s
                
                Available events:
                %s
                
                Recommend the most relevant events for this user.
                Explain briefly why each recommendation matches
                their interests. Keep response concise and friendly.
                """.formatted(userInterests, eventList);

        log.info("Asking AI for recommendations for: {}",
                userInterests);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}

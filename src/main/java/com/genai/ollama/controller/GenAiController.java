package com.genai.ollama.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.genai.ollama.dto.ChatRequest;
import com.genai.ollama.dto.SummaryReport;
import com.genai.ollama.service.GenAiService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/ai")
public class GenAiController {

    private final GenAiService aiService;

    public GenAiController(GenAiService aiService) {
        this.aiService = aiService;
    }

    // Standard JSON Response Endpoint
    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {
        return aiService.generateAnswer(request.prompt());
    }

    // Streaming Response Endpoint (Real-time typewriter effect)
    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChat(@RequestBody ChatRequest request) {
        return aiService.streamAnswer(request.prompt());
    }

    // Structured JSON Response
    @PostMapping("/report")
    public SummaryReport generateReport(@RequestBody ChatRequest request) {
        return aiService.generateStructuredReport(request.prompt());
    }
}

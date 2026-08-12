package com.genai.ollama.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.genai.ollama.dto.SummaryReport;

import reactor.core.publisher.Flux;

@Service
public class GenAiService {

    private final ChatClient chatClient;

    public GenAiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    // 1. Standard Synchronous Call
    public String generateAnswer(String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    // 2. Real-time Streaming Response (Server-Sent Events)
    public Flux<String> streamAnswer(String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .stream()
                .content();
    }

    // 3. Structured Output (LLM output directly mapped to Java POJO/Record)
    public SummaryReport generateStructuredReport(String textToAnalyze) {
        return chatClient.prompt()
                .user("Analyze the following text and return a structured summary report:\n\n" + textToAnalyze)
                .call()
                .entity(SummaryReport.class);
    }
}

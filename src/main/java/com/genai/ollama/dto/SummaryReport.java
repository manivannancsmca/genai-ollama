package com.genai.ollama.dto;

import java.util.List;

public record SummaryReport(
        String title,
        List<String> keyTakeaways,
        String sentiment
) {}

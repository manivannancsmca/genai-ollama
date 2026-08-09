# Spring Boot + Ollama REST API

This guide explains how to start Ollama, run the Spring Boot application, and test the available REST APIs.

## 🚀 Setup & Run

### Step 1: Ensure Ollama Is Running

Make sure Ollama is active on your system and the `llama3.2` model is available:

```bash
ollama run llama3.2
```

### Step 2: Start Spring Boot

Start the Spring Boot application using Maven:

```bash
mvn clean spring-boot:run
```

The application should be available at:

```text
http://localhost:8080
```

## 🧪 Step 3: Test REST APIs

### 1. Standard Chat

Send a prompt to the standard chat endpoint:

```bash
curl -X POST http://localhost:8080/api/v1/ai/chat \
  -H "Content-Type: application/json" \
  -d '{"prompt": "Explain dependency injection in 2 sentences."}'
```

### 2. Streaming Output (SSE)

Use the streaming endpoint to receive the AI response incrementally using Server-Sent Events (SSE):

```bash
curl -N -X POST http://localhost:8080/api/v1/ai/stream \
  -H "Content-Type: application/json" \
  -d '{"prompt": "Write a short poem about Java."}'
```

### 3. Structured JSON Response

Send a prompt to the report endpoint and receive a structured JSON response:

```bash
curl -X POST http://localhost:8080/api/v1/ai/report \
  -H "Content-Type: application/json" \
  -d '{"prompt": "The launch of our new cloud app was successful! Users love the performance, though some requested dark mode support."}'
```

#### Example Output

```json
{
  "title": "Cloud App Launch Analysis",
  "keyTakeaways": [
    "Application launch was successful",
    "Users praised overall system performance",
    "Dark mode requested as a future feature"
  ],
  "sentiment": "Positive"
}
```

## 📌 API Summary

| Endpoint | Method | Purpose |
|---|---|---|
| `/api/v1/ai/chat` | POST | Standard AI chat response |
| `/api/v1/ai/stream` | POST | Streaming AI response using SSE |
| `/api/v1/ai/report` | POST | Structured JSON report generation |

## 🛑 Stopping Ollama

If Ollama was started interactively with:

```bash
ollama run llama3.2
```

you can stop the running session with:

```text
Ctrl + C
```

package com.fitness.aiservice.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
@Slf4j
@NoArgsConstructor
public class GenAiService {
    public String getAnswer(String question){
        GenerateContentResponse response;
        try (Client client = new Client()) {
            response = client.models.generateContent(
                    "gemini-3-flash-preview",
                    question,
                    null);
        }
        return response.text();
    }
}

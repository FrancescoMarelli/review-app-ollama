package com.portfolio.deepseek.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OllamaService {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${ollama.base-url}")
    private String ollamaBaseUrl;
    @Value("${ollama.model}")
    private String ollamaModel;

    public String generateText(String prompt) {
        String url = ollamaBaseUrl + "/api/generate";

        Map<String, Object> requestBody = Map.of(
            "model", ollamaModel,
            "prompt", prompt
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la petición
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            // Enviar la solicitud a Ollama
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
                return parseDeepseekResponse(responseEntity.getBody());
            } else {
                log.error("Error en la respuesta de Ollama: {}", responseEntity.getStatusCode());
                return "Error al comunicarse con Ollama";
            }

        } catch (Exception e) {
            log.error("Error al conectar con Ollama: {}", e.getMessage(), e);
            return "Error en la conexión con Ollama";
        }
    }

    private String parseDeepseekResponse(String response) {
        StringBuilder fullResponse = new StringBuilder();

        String[] lines = response.split("\n");

        for (String line : lines) {
            try {
                JSONObject jsonObject = new JSONObject(line);
                fullResponse.append(jsonObject.optString("response", ""));

                if (jsonObject.optBoolean("done", false)) {
                    break;
                }
            } catch (Exception e) {
                log.error("Error al parsear la línea: {}", line, e);
            }
        }

        return fullResponse.toString();
    }

}
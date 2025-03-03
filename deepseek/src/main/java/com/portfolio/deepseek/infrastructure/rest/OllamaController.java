package com.portfolio.deepseek.infrastructure.rest;

import com.portfolio.deepseek.application.OllamaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class OllamaController {

    private final OllamaService ollamaService;

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {
        return ollamaService.generateText(prompt);
    }
}
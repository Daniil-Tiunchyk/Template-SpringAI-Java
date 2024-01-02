package com.chatgpt.springai;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class PromptController {

    private final ChatClient chatClient;
    private static final Logger logger = LoggerFactory.getLogger(PromptController.class);

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        try {
            String prompt = "Привет, как на китайском будет Hello World?";
            String response = chatClient.generate(prompt);
            logger.info("Response received: {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error during API call", e);
            return ResponseEntity.internalServerError().body("Произошла ошибка при вызове API");
        }
    }

    @GetMapping("/{prompt}")
    public ResponseEntity<String> sendPrompt(@PathVariable String prompt) {
        if (prompt == null || prompt.isBlank()) {
            return ResponseEntity.badRequest().body("Prompt cannot be empty");
        }
        try {
            String response = chatClient.generate(prompt);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error during processing prompt", e);
            return ResponseEntity.internalServerError().body("Error processing prompt");
        }
    }

    @GetMapping("/learn/{message}")
    public ResponseEntity<String> getMessage(@PathVariable("message") String message) {
        if (message == null || message.isBlank()) {
            return ResponseEntity.badRequest().body("Message cannot be empty");
        }
        try {
            PromptTemplate promptTemplate = new PromptTemplate("Пожалуйста, расскажи кратко и доступным языком что такое " + message + ".");

            String response = this.chatClient.generate(promptTemplate.create()).getGeneration().getContent();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error during generating message", e);
            return ResponseEntity.internalServerError().body("Error generating message");
        }
    }
}

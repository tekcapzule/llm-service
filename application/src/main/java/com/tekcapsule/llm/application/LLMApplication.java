package com.tekcapsule.llm.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tekcapsule.course","com.tekcapsule.core"})
public class LLMApplication {
    public static void main(String[] args) {
        SpringApplication.run(LLMApplication.class, args);
    }
}

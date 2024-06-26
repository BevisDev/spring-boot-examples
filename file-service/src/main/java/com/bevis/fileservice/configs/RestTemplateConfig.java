package com.bevis.fileservice.configs;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestTemplateConfig {

    AppConfig appConfig;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(appConfig.getRestTemplateConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(appConfig.getRestTemplateReadTimeout()))
                .build();
    }
}

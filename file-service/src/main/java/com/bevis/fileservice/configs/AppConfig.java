package com.bevis.fileservice.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfig {

    @Value("${app.name}")
    String appName;

    @Value("${app.version}")
    String appVersion;

    @Value("${build.date}")
    String buildDate;

    @Value("${restTemplate.connectTimeout}")
    int restTemplateConnectTimeout;

    @Value("${restTemplate.readTimeout}")
    int restTemplateReadTimeout;
}

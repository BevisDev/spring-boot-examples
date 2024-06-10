package com.bevis.admin.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfiguration {

    @Value("${profile.active}")
    String profileActive;

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

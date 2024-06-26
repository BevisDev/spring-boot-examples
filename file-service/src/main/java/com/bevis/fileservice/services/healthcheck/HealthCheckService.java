package com.bevis.fileservice.services.healthcheck;

import java.net.InetAddress;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.bevis.fileservice.configs.AppConfig;
import com.bevis.fileservice.dtos.responses.HealthCheckResp;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HealthCheckService implements IHealthCheckService {
    static String HEALTH_CHECK_SERVICE = "Health Check System";
    static String RUNNING_STATUS = "RUNNING";

    AppConfig _appConfig;

    @Override
    public HealthCheckResp getStatusSystem(boolean isDetail) {
        HealthCheckResp healthCheckResp = new HealthCheckResp();
        healthCheckResp.setService(HEALTH_CHECK_SERVICE);
        healthCheckResp.setStatus(RUNNING_STATUS);
        healthCheckResp.setRequestTime(new Date());
        if (!isDetail) {
            return healthCheckResp;
        }
        healthCheckResp.setAppName(_appConfig.getAppName());
        healthCheckResp.setAppVersion(_appConfig.getAppVersion());
        healthCheckResp.setBuildDate(_appConfig.getBuildDate());
        try {
            healthCheckResp.setPodName(InetAddress.getLocalHost().getHostName());
        } catch (Exception e) {
            log.error("cannot get hostname: ", e);
        }
        return healthCheckResp;
    }
}

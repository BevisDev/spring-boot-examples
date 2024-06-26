package com.bevis.fileservice.controllers;

import com.bevis.fileservice.consts.ApiConst;
import com.bevis.fileservice.dtos.responses.HealthCheckResp;
import com.bevis.fileservice.services.healthcheck.IHealthCheckService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HealthCheckController {

    IHealthCheckService _healthCheckService;

    @GetMapping(ApiConst.STATUS_PATH)
    public HealthCheckResp getStatus(@RequestParam(value = "isDetail", required = false) boolean isDetail) {
        return _healthCheckService.getStatusSystem(isDetail);
    }
}

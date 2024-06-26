package com.bevis.fileservice.services.healthcheck;

import com.bevis.fileservice.dtos.responses.HealthCheckResp;

public interface IHealthCheckService {

    /**
     * health check system status
     *
     * @param isDetail want to get detail
     * @return result
     */
    HealthCheckResp getStatusSystem(boolean isDetail);
}

package com.bevis.fileservice.services;

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

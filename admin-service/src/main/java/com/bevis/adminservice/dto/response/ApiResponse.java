package com.bevis.adminservice.dto.response;

import java.io.Serial;
import java.io.Serializable;

import com.bevis.adminservice.enums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5952913922941280904L;

    boolean success = true;
    T result;
    String code;
    String message;

    public void setError(ErrorCode errorCode) {
        this.success = false;
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}

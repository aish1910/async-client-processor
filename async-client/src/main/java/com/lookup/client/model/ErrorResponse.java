package com.lookup.client.model;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String id;
    private HttpStatus statusCode;
    private String reason;

    public ErrorResponse() {
    }
    public ErrorResponse(String id, HttpStatus statusCode, String reason) {
        this.id = id;
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "id='" + id + '\'' +
                ", statusCode=" + statusCode +
                ", reason='" + reason + '\'' +
                '}';
    }
}

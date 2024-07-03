package me.dio.infra;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {

    private Integer statusCode;
    private HttpStatus httpMessage;
    private String message;

    public RestErrorMessage(Integer statusCode, HttpStatus httpMessage, String message) {
        this.statusCode = statusCode;
        this.httpMessage = httpMessage;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getHttpMessage() {
        return httpMessage;
    }

    public void setHttpMessage(HttpStatus httpMessage) {
        this.httpMessage = httpMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

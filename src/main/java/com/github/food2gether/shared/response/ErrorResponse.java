package com.github.food2gether.shared.response;

import lombok.AllArgsConstructor;

public final class ErrorResponse extends Response {

    private final Error error;

    ErrorResponse(int code, String messageKey) {
        super(false);
        this.error = new Error(code, messageKey);
    }

    public int getCode() {
        return this.error.code;
    }

    public String getDetail() {
        return this.error.detail;
    }

    public void setCode(int code) {
        this.error.code = code;
    }

    public void setDetail(String messageKey) {
        this.error.detail = messageKey;
    }

    // used to achieve a structure where the error is a field of the response
    @AllArgsConstructor
    private static class Error {

        private int code;

        private String detail;

    }

}

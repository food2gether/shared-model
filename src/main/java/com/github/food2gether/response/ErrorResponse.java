package com.github.food2gether.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public final class ErrorResponse extends Response {

    private final Error error;

    ErrorResponse(int code, String messageKey) {
        super(false);
        this.error = new Error(code, messageKey);
    }

    // used to achieve a structure where the error is a field of the response
    @Data
    @AllArgsConstructor
    private static class Error {

        private int code;

        private String detail;

    }

}

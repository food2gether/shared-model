package com.github.food2gether.shared.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract sealed class Response permits ErrorResponse, DataResponse {

    private boolean success;

    public static <T> DataResponse<T> of(T data) {
        return new DataResponse<T>(data);
    }

    public static ErrorResponse of(int code, String message) {
        return new ErrorResponse(code, message);
    }

    public static ErrorResponse of(Exception error) {
        return new ErrorResponse(500, error.getMessage());
    }

}

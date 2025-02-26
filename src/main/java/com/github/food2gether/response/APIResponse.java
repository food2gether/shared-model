package com.github.food2gether.response;

import jakarta.ws.rs.core.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class APIResponse {

    private int status;

    public static Response response(APIResponse response) {
        return Response.status(response.getStatus()).entity(response).build();
    }

    public static <T> Response response(T data) {
        return response(apiResponse(data));
    }

    public static <T> Response response(int code, T data) {
        return response(apiResponse(code, data));
    }

    public static <T> Response response(Response.Status code, T data) {
        return response(code.getStatusCode(), data);
    }

    public static <D> APIResponse apiResponse(int code, D data) {
        if (data instanceof Throwable t) {
            return apiErrorResponse(code, t.getMessage());
        } else {
            return apiDataResponse(code, data);
        }
    }

    public static <D> APIResponse apiResponse(D data) {
        if (data instanceof Throwable t) {
            return apiErrorResponse(t.getMessage());
        } else {
            return apiDataResponse(data);
        }
    }

    public static <D> APIResponse apiResponse(Response.Status code, D data) {
        return apiResponse(code.getStatusCode(), data);
    }

    public static <T> APIResponse apiDataResponse(int code, T data) {
        return new DataAPIResponse<>(code, data);
    }

    public static <T> APIResponse apiDataResponse(Response.Status code, T data) {
        return apiDataResponse(code.getStatusCode(), data);
    }

    public static <T> APIResponse apiDataResponse(T data) {
        return apiDataResponse(Response.Status.OK, data);
    }

    public static APIResponse apiErrorResponse(int code, String message) {
        return new ErrorAPIResponse(code, message);
    }

    public static APIResponse apiErrorResponse(Response.Status code, String message) {
        return apiErrorResponse(code.getStatusCode(), message);
    }

    public static APIResponse apiErrorResponse(String message) {
        return apiErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, message);
    }

}

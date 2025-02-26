package com.github.food2gether.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ErrorAPIResponse extends APIResponse {

    private String message;

    ErrorAPIResponse(int status, String message) {
        super(status);
        this.message = message;
    }

}

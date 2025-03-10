package com.github.food2gether.shared.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class DataAPIResponse<T> extends APIResponse {

    private T data;

    DataAPIResponse(int status, T data) {
        super(true, status);
        this.data = data;
    }

}

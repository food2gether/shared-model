package com.github.food2gether.shared.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public non-sealed class DataResponse<T> extends Response {

    private T data;

    DataResponse(T data) {
        super(true);
        this.data = data;
    }

}

package com.github.food2gether.shared;

import com.github.food2gether.shared.response.APIResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class ExceptionHandler {

  public static Response handle(Exception e) {
    if (e instanceof WebApplicationException webApplicationException) {
      return APIResponse.response(webApplicationException.getResponse().getStatus(), e);
    }
    if (e instanceof EntityNotFoundException) {
      return APIResponse.response(Response.Status.NOT_FOUND, e);
    }

    return APIResponse.response(e);
  }

}

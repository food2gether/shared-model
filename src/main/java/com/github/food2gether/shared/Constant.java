package com.github.food2gether.shared;

import com.github.food2gether.shared.model.*;
import com.github.food2gether.shared.response.DataAPIResponse;
import com.github.food2gether.shared.response.ErrorAPIResponse;

public class Constant {

    public static final String USER_MAIL_HEADER = "X-User-Mail";

    public static final Class<?>[] REGISTER_FOR_REFLECTION = {
            ContactInformation.DTO.class,
            MenuItem.DTO.class,
            Order.DTO.class,
            OrderItem.DTO.class,
            Profile.DTO.class,
            Restaurant.DTO.class,
            Session.DTO.class,
            DataAPIResponse.class,
            ErrorAPIResponse.class
    };

}

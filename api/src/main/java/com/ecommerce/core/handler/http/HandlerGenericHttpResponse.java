package com.ecommerce.core.handler.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HandlerGenericHttpResponse {

    private String errorMessage;
    private String dateTime;
    private String calledUrl;
    private int statusCode;
    private String method;

}

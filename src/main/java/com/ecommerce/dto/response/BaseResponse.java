package com.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> {
    private Integer code;
    private String message;
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T error;
}

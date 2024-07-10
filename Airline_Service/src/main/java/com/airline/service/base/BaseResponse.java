package com.airline.service.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T>{
    public Integer statusCode;
    public String message;

    public T data;

}

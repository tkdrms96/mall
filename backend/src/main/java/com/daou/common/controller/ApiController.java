package com.daou.common.controller;

import com.daou.common.exception.BaseException;
import com.daou.common.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiController {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleBaseException(BaseException e) {
        return new ErrorResponse(e.isSuccess(), e.getDetailMessage());
    }
}

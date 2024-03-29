package com.ft.house.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: fut
 * Time:   2019-07-27
 * Motto:  Work conscientiously and be a practical man.
 */
@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(value={Exception.class,RuntimeException.class})
    public String error500(HttpServletRequest request, Exception e){
        log.error(e.getMessage(),e);
        log.error(request.getRequestURL() + " encounter 500");
        return "error/500";
    }
}

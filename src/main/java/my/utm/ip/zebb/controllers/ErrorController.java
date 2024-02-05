package my.utm.ip.zebb.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointer(Exception e){
        return("main/error");
    }
}

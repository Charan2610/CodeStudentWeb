package com.Student.Controllers;

import com.Student.Exceptions.Error;
import com.Student.Exceptions.StudentException;
import com.Student.Models.ShowError;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@ControllerAdvice

public class ExceptionController {


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public @ResponseBody
    ShowError exception(final Error exception, final HttpServletRequest request){

        ShowError error = new ShowError();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        error.setError(exception.getMessage());
        error.setTimeStamp(timeStamp);
        error.setPath(request.getRequestURI());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return error;
    }


    @ExceptionHandler(Error.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ShowError addStudentException(final Error exception, final HttpServletRequest request){

        ShowError error = new ShowError();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        error.setError(exception.getMessage());
        error.setTimeStamp(timeStamp);
        error.setPath(request.getRequestURI());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return error;
    }
}

package com.etiya.library.system.core.exceptions;

import com.etiya.library.system.core.exceptions.types.BusinessException;
import com.etiya.library.system.core.result.ErrorDataResult;
import com.etiya.library.system.core.result.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {


    /**
     * Exception handler for validation exceptions.
     * @param exception Thrown validation exception
     * @return ErrorDataResult
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Map<String,String>> handleValidationException(MethodArgumentNotValidException exception)
    {
        Map<String,String> errors = new HashMap<>();

        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<>(errors, "Validasyon hataları mevcut.");
    }

    /**
     * Exception handler for business exceptions.
     * @param exception Thrown business exception
     * @return ErrorResult
     */
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBusinessException(BusinessException exception)
    {
        return new ErrorResult(exception.getMessage());
    }


}

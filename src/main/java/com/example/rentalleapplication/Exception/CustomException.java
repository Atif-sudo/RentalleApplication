package com.example.rentalleapplication.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.lang.RuntimeException;

@Getter
@Setter
@AllArgsConstructor
public class CustomException extends RuntimeException {


    private String ErrorMessage;
    private HttpStatus Status;
    private long statusCode;
}

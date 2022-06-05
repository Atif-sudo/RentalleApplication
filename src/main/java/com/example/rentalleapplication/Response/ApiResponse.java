package com.example.rentalleapplication.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T>{


        private String Message;
        private HttpStatus Status;

        private long statusCode;
        private T Data;

        private String Error;


    }


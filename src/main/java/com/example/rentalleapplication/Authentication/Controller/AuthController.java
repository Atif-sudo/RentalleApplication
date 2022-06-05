package com.example.rentalleapplication.Authentication.Controller;

import com.example.rentalleapplication.Authentication.Models.LoginData;
import com.example.rentalleapplication.Authentication.Models.SignInData;
import com.example.rentalleapplication.Authentication.Services.IauthService;
import com.example.rentalleapplication.Exception.CustomException;
import com.example.rentalleapplication.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {

    @Autowired
    IauthService iauthService;


    @PostMapping("/Rentalle/v1/authentication/signUp")
    public ResponseEntity<ApiResponse<?>> signInRequest(@RequestBody SignInData signInData) {
        ApiResponse<?> apiResponse = iauthService.signUpUser(signInData);
        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }


    @PostMapping("/Rentalle/v1/authentication/login")
    public ResponseEntity<ApiResponse<?>> loginRequest(@RequestBody LoginData loginData, HttpServletResponse response){
        ApiResponse<?> apiResponse= iauthService.loginUser(loginData);

        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());

    }




    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<?>> handleException (CustomException e){

        ApiResponse<?> apiResponse = new ApiResponse<>(null,
                e.getStatus(),
                e.getStatusCode(),
                null,
                e.getErrorMessage());

        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }

}

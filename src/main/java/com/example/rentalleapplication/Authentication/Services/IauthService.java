package com.example.rentalleapplication.Authentication.Services;

import com.example.rentalleapplication.Authentication.Models.LoginData;
import com.example.rentalleapplication.Authentication.Models.SignInData;
import com.example.rentalleapplication.Response.ApiResponse;

public interface IauthService {

    ApiResponse signUpUser(SignInData signinRequest) ;


    ApiResponse<?> loginUser(LoginData loginData);
}

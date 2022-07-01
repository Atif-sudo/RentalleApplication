package com.example.rentalleapplication.Authentication.Services;

import com.example.rentalleapplication.Authentication.Models.AdminData;
import com.example.rentalleapplication.Authentication.Models.LoginData;
import com.example.rentalleapplication.Authentication.Models.LoginDbData;
import com.example.rentalleapplication.Authentication.Models.SignInData;
import com.example.rentalleapplication.Authentication.Repository.IauthRepo;
import com.example.rentalleapplication.Exception.CustomException;
import com.example.rentalleapplication.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Array;

@Service
public class AuthService implements IauthService {

    @Autowired
    IauthRepo iauthRepo;
    @Override
    public ApiResponse signUpUser(SignInData signInData) {


//        SignInData signInData;


        try {


         iauthRepo.setUserData(signInData);


        }catch(Exception e) {
//            System.out.println(e.getMessage());
            throw new CustomException(e.getMessage(),HttpStatus.UNAUTHORIZED ,HttpStatus.UNAUTHORIZED.value());
        }

        return new ApiResponse<>(
                "Registration successfull",
                HttpStatus.OK,
                HttpStatus.OK.value(),
                null,
                null);
        }

    @Override
    public ApiResponse<?> loginUser(LoginData loginData) {

            LoginDbData loginDbData= null;
        try {

             loginDbData= iauthRepo.getData(loginData.getEmail());

        }
        catch (Exception e){
            throw new CustomException(e.getMessage(),HttpStatus.UNAUTHORIZED,HttpStatus.UNAUTHORIZED.value());
        }
        if(loginDbData == null){
            throw new CustomException("Email/Password is incorrect........",HttpStatus.UNAUTHORIZED,HttpStatus.UNAUTHORIZED.value());
        }
        if( ! loginData.getPassword().equals(loginDbData.getPassword()) ){
            throw new CustomException("Email/Password is incorrect..",HttpStatus.UNAUTHORIZED,HttpStatus.UNAUTHORIZED.value());
        }

        return new ApiResponse<>(
                "Login Successful..",
                HttpStatus.OK,
                HttpStatus.OK.value(),
                new LoginDbData(

                        loginDbData.getId(),
                        loginDbData.getEmail(),
                        loginDbData.getFullName(),
                        null,
                        loginDbData.getMobileNo(),
                        loginDbData.getIs_customer(),
                        loginDbData.getIs_seller(),
                        loginDbData.getAddress(),
                        null
                )
                ,
                null);
    }
}


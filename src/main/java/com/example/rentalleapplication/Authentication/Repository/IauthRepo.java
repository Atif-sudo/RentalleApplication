package com.example.rentalleapplication.Authentication.Repository;
import com.example.rentalleapplication.Authentication.Models.LoginData;
import com.example.rentalleapplication.Authentication.Models.LoginDbData;
import com.example.rentalleapplication.Authentication.Models.SignInData;

import java.util.List;

public interface IauthRepo {

//    AdminData getData(int email);

     LoginDbData getData(String email);

    void setUserData(SignInData signInData);

//     LoginData getData(String email);

//     void getUserData(LoginData loginData);
}

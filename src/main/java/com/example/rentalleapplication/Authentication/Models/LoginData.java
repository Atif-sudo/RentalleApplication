package com.example.rentalleapplication.Authentication.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {

    @JsonProperty("Email")
    private String Email;

    @JsonProperty("Password")
    private String Password;
}

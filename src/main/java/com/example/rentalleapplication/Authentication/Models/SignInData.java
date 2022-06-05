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
public class SignInData {


   @JsonProperty("Email")
    private String Email;

    @JsonProperty("FullName")
    private String FullName;

    @JsonProperty("Password")
    private String Password;

    @JsonProperty("MobileNo")
    private String MobileNo;

    @JsonProperty("is_customer")
    private boolean is_customer;

    @JsonProperty("is_seller")
    private boolean is_seller;

    @JsonProperty("Address")
    private String Address;

    @JsonProperty("ProofID")
    private String ProofID;
}

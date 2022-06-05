package com.example.rentalleapplication.Authentication.Repository;

import com.example.rentalleapplication.Authentication.Models.LoginDbData;
import com.example.rentalleapplication.Authentication.Models.SignInData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class authRepo  implements  IauthRepo{


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public LoginDbData getData(String email) {
        String sqlQuery = "SELECT * from Users where Email = ?";

        return (LoginDbData) jdbcTemplate.queryForObject(
                sqlQuery,
                new Object[]{email},
                new BeanPropertyRowMapper(LoginDbData.class));
      // return (AdminData) jdbcTemplate.queryForObject(sqlQuery,new Object[] {email},new String[] {},new BeanPropertyRowMapper<AdminData>(AdminData.class));
    }

    @Override
    public void setUserData(SignInData signInData) {
        String sqlQuery = "INSERT INTO Users (Email, Password, FullName, MobileNo, Address, ProofID, is_customer, is_seller )\n" +
                "VALUES (?,?,?,?,?,?,?,?);";

         jdbcTemplate.update(
                sqlQuery,
                new Object[]{signInData.getEmail(),
                        signInData.getPassword(),
                        signInData.getFullName(),
                        signInData.getMobileNo(),
                        signInData.getAddress(),
                        signInData.getProofID(),
                        signInData.is_customer(),
                        signInData.is_seller()});

    }

//    @Override
//    public void setUserData(LoginData loginData) {
//
//
//    }
}

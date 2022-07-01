package com.example.rentalleapplication.Product.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentedProducts {

    private String ProductName;

    private String RentedDate;

    private String Email;

    private String DueDate;

    private int id;



}

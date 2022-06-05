package com.example.rentalleapplication.Product.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsPojo {

    private int productId;

    private int CategoryID;

    private int SubCategoryID;

    private String SubCategoryName;

    private String ProductName;

    private String ProductDescription;

    private int PricePerMonth;

    private boolean StatusAvailibility;

}

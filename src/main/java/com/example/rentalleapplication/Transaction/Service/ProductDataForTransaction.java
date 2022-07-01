package com.example.rentalleapplication.Transaction.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataForTransaction {

    private int TotalProduct;

    private int SellerID;

    private String PricePerMonth;

}

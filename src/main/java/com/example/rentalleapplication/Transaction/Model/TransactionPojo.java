package com.example.rentalleapplication.Transaction.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPojo {

    private int pId;

    private int SellerID;

    private String amount;

    private int TotalProduct;


}
package com.example.rentalleapplication.Product.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUploadData {

        @JsonProperty("CategoryID")
        private int CategoryID;

        @JsonProperty("ProductName")
        private String ProductName;

        @JsonProperty("ProductDescription")
        private String ProductDescription;

        @JsonProperty("TotalProduct")
        private int TotalProduct;

//        @JsonProperty("PhotoUpload")
//        private String PhotoUpload;

        @JsonProperty("PricePerMonth")
        private int PricePerMonth;

        @JsonProperty("SellerID")
        private int SellerID;
}

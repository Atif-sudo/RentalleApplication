package com.example.rentalleapplication.Transaction.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionData {
        @JsonProperty("products")
        private List<Products> product;

    @JsonProperty("userId")
    private int UserID;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
        public static class Products {
            @JsonProperty("productId")
            private int id;
            @JsonProperty("amount")
            private String amount;
            @JsonProperty("totalProduct")
            private int totalProduct;
        }

}

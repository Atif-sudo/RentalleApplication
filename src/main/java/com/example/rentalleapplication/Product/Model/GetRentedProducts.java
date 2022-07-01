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
public class GetRentedProducts {

    @JsonProperty("id")
    private int id;
    @JsonProperty("isCustomer")
    private boolean isCustomer;

}

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
public class GetProductDataRequest {

    @JsonProperty("id")
    private int categoryId;

    @JsonProperty("limit")
    private int limit;

}

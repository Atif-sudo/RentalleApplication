package com.example.rentalleapplication.Category.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryList {

    @JsonProperty("ID")
    private int sub_cat_id;

    @JsonProperty("SubCategoryName")
    private String SubCategoryName;
}

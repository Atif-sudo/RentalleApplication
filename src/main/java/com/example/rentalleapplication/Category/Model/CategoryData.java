package com.example.rentalleapplication.Category.Model;

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
public class CategoryData {

    @JsonProperty("ID")
    private int id;
    @JsonProperty("CategoryName")
    private String CategoryName;

    @JsonProperty("category_logo")
    private String category_logo;

    @JsonProperty("category_action")
    private String category_action;


}

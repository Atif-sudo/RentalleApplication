package com.example.rentalleapplication.Category.Repo;

import com.example.rentalleapplication.Category.Model.CategoryData;

import java.util.List;

public interface ICatRepo {
    List<CategoryData> getCategoriesFromDb();
}

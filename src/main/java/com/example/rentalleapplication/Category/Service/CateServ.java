package com.example.rentalleapplication.Category.Service;

import com.example.rentalleapplication.Category.Model.CategoryData;
import com.example.rentalleapplication.Category.Repo.ICatRepo;
import com.example.rentalleapplication.Exception.CustomException;
import com.example.rentalleapplication.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServ implements ICateServ {

    @Autowired
    ICatRepo iCatRepo;

    public ApiResponse<?> getCategories() {

        List<CategoryData> categoryData = null;
        try {
           categoryData = iCatRepo.getCategoriesFromDb();


        }catch (Exception e) {
            throw new CustomException("Something went wrong at our side while fetching the categoires list, will fix this soon", HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
        }
        return new ApiResponse<>(
                "Success",
                HttpStatus.OK,
                HttpStatus.OK.value(),
                categoryData,
                null);

    }

}

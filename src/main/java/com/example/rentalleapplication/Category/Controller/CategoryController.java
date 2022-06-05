package com.example.rentalleapplication.Category.Controller;

import com.example.rentalleapplication.Category.Model.CategoryData;
import com.example.rentalleapplication.Category.Service.ICateServ;
import com.example.rentalleapplication.Exception.CustomException;
import com.example.rentalleapplication.Product.Service.IProductServ;
import com.example.rentalleapplication.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class CategoryController {

    @Autowired
    ICateServ iCateServ;

    @GetMapping("/Rentalle/v1/category/lists")
    public ResponseEntity<ApiResponse<?>> categoryList() {

        ApiResponse<?> apiResponse =  iCateServ.getCategories();

        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<?>> handleException (CustomException e){

        ApiResponse<?> apiResponse = new ApiResponse<>(null,
                e.getStatus(),
                e.getStatusCode(),
                null,
                e.getErrorMessage());

        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }

}

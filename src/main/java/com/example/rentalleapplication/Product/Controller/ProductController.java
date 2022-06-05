package com.example.rentalleapplication.Product.Controller;



import com.example.rentalleapplication.Exception.CustomException;
import com.example.rentalleapplication.Product.Model.GetProductDataRequest;
import com.example.rentalleapplication.Product.Model.ProductUploadData;
import com.example.rentalleapplication.Product.Service.IProductServ;
import com.example.rentalleapplication.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    @Autowired
    IProductServ iProductServ;


    @PostMapping("/Rentalle/v1/product/upload")
    public ResponseEntity<ApiResponse<?>> upload(@RequestBody ProductUploadData productUploadData) {
        ApiResponse<?> apiResponse = iProductServ.upload(productUploadData);
        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }

    @PostMapping("/Rentalle/v1/product/getProduct")
    public ResponseEntity<ApiResponse<?>> getProducts(@RequestBody GetProductDataRequest getProductDataRequest) {
        ApiResponse<?> apiResponse = iProductServ.getProducts(getProductDataRequest);
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

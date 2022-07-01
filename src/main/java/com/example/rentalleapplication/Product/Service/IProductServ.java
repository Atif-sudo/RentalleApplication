package com.example.rentalleapplication.Product.Service;

import com.example.rentalleapplication.Product.Model.GetProductDataRequest;
import com.example.rentalleapplication.Product.Model.GetRentedProducts;
import com.example.rentalleapplication.Product.Model.ProductUploadData;
import com.example.rentalleapplication.Response.ApiResponse;

public interface IProductServ {
    ApiResponse<?> upload(ProductUploadData productUploadData);

    ApiResponse<?> getProducts(GetProductDataRequest getProductDataRequest);

    ApiResponse<?> getRentedProducts(GetRentedProducts getProductDataRequest);
}

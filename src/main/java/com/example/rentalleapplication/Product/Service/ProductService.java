package com.example.rentalleapplication.Product.Service;


import com.example.rentalleapplication.Exception.CustomException;
import com.example.rentalleapplication.Product.Model.*;
import com.example.rentalleapplication.Product.Repository.IProductRepo;
import com.example.rentalleapplication.Response.ApiResponse;
import com.example.rentalleapplication.Transaction.Model.TransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductServ{

    @Autowired
    IProductRepo iProductRepo;
    @Override
    public ApiResponse<?> upload(ProductUploadData productUploadData) {

        try{
                iProductRepo.setProductData(productUploadData);
        }
        catch (Exception e) {
            throw new CustomException("Something went wrong at our side while Uploading the product details, will fix this soon", HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
        }
        return new ApiResponse<>(
                "Product Successfully Uploaded",
                HttpStatus.OK,
                HttpStatus.OK.value(),
                null,
                null);
    }

    @Override
    public ApiResponse<?> getProducts(GetProductDataRequest getProductDataRequest) {
        List<ProductsPojo> productsPojoList;
        try {
           productsPojoList  = iProductRepo.getProductList(getProductDataRequest.getCategoryId(), getProductDataRequest.getLimit());
        }catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
        }
        return new ApiResponse<>(
                "Product Details Fetched Successfully",
                HttpStatus.OK,
                HttpStatus.OK.value(),
                productsPojoList,
                null);
    }

    @Override
    public ApiResponse<?> getRentedProducts(GetRentedProducts getProductDataRequest) {
        List<RentedProducts> rentedProducts ;
        try{
           rentedProducts =  getProductDataRequest.isCustomer() ? iProductRepo.getRentedProductsByUserId(getProductDataRequest.getId()) : iProductRepo.getSelledProductsBySellerID(getProductDataRequest.getId());
        }catch (Exception e) {
            throw  new CustomException(e.getMessage(),HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
        }
        List<EmailPojo> emails;

        try {
            emails = getProductDataRequest.isCustomer() ? iProductRepo.getEmailByUserId(getProductDataRequest.getId()) : iProductRepo.getEmailBySellerId(getProductDataRequest.getId());
        }catch(Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
        }
        int emailListSize = emails.size();
       for (RentedProducts rp : rentedProducts) {
           for(int i=0;i<emailListSize;i++){
               if(rp.getId() == emails.get(i).getID()){
                   rp.setEmail(emails.get(i).getEmail());
               }
           }
       }




        return new ApiResponse<>(
                "Product Details Fetched Successfully",
                HttpStatus.OK,
                HttpStatus.OK.value(),
                rentedProducts,
                null);
    }
}

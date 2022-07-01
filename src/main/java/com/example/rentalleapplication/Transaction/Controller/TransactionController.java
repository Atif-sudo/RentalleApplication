package com.example.rentalleapplication.Transaction.Controller;

import com.example.rentalleapplication.Exception.CustomException;
import com.example.rentalleapplication.Response.ApiResponse;
import com.example.rentalleapplication.Transaction.Model.TransactionData;
import com.example.rentalleapplication.Transaction.Service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
public class TransactionController {

    @Autowired
    ITransactionService iTransactionService;

    @PostMapping("/Rentalle/v1/product/transact")
    public ResponseEntity<ApiResponse<?>> upload(@RequestBody TransactionData transactionData) {


        ;

         ApiResponse<?> apiResponse =  iTransactionService.startTransaction(transactionData);
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

//    @PostMapping("/Rentalle/v1/product/getRentedProdcuts")
//    public ResponseEntity<ApiResponse<?>> getProducts(@RequestBody) {
//
//    }
//

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<?>> handleException(CustomException e) {

        ApiResponse<?> apiResponse = new ApiResponse<>(null,
                e.getStatus(),
                e.getStatusCode(),
                null,
                e.getErrorMessage());

        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

}

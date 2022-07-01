package com.example.rentalleapplication.Transaction.Service;

import com.example.rentalleapplication.Exception.CustomException;
import com.example.rentalleapplication.Product.Repository.IProductRepo;
import com.example.rentalleapplication.Response.ApiResponse;
import com.example.rentalleapplication.Transaction.Model.TransactionData;
import com.example.rentalleapplication.Transaction.Model.TransactionPojo;
import com.example.rentalleapplication.Transaction.Repository.ITransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import static java.lang.Integer.parseInt;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    ITransactionRepo iTransactionRepo;

    @Autowired
    IProductRepo iProductRepo;

    @Override
    public ApiResponse<?> startTransaction(TransactionData transactionData){

        for (TransactionData.Products tData: transactionData.getProduct()
             ) {
            TransactionPojo txnProduct = validateProductIdandAmount(tData);
            UUID referenceId = UUID.randomUUID();

            LocalDate currentDate = LocalDate.now();
            LocalDate dueDate = currentDate.plusMonths(1);
            try{
                iProductRepo.updateTotalProductAndAvailability(txnProduct.getPId(), txnProduct.getTotalProduct() > 0);
                iTransactionRepo.initiateTransaction(txnProduct,transactionData.getUserID(), txnProduct.getSellerID(),referenceId.toString(),currentDate.toString());
                iProductRepo.updateRentedProductTable(txnProduct,transactionData.getUserID(), txnProduct.getSellerID(),currentDate.toString(),dueDate.toString());
            }catch(Exception e) {
                throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
            }
        }

        return new ApiResponse<>(
                "Order is successfully completed",
                HttpStatus.OK,
                HttpStatus.OK.value(),
                transactionData,
                null);
    }

    private TransactionPojo validateProductIdandAmount(TransactionData.Products transactionData) {
        TransactionPojo transactionPojo;
        try {
          transactionPojo =   iTransactionRepo.getTransactionIdAndAmountByProductId(transactionData.getId(), transactionData.getAmount());
        }catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
        }
        int databaseAmount = parseInt(transactionPojo.getAmount() ) * transactionData.getTotalProduct();
        if(!String.valueOf(databaseAmount).equals(transactionData.getAmount())){
            throw new CustomException("Amount not applicable",HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value());
        }
    return transactionPojo;
    }
}

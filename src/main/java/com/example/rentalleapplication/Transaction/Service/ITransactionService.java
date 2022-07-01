package com.example.rentalleapplication.Transaction.Service;

import com.example.rentalleapplication.Response.ApiResponse;
import com.example.rentalleapplication.Transaction.Model.TransactionData;

public interface ITransactionService {
    ApiResponse<?> startTransaction(TransactionData transactionData);
}

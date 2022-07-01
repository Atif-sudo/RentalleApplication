package com.example.rentalleapplication.Transaction.Repository;

import com.example.rentalleapplication.Transaction.Model.TransactionPojo;

public interface ITransactionRepo {
    TransactionPojo getTransactionIdAndAmountByProductId(int id, String amount);

    void initiateTransaction(TransactionPojo txnProduct, int userId, int sellerID, String referenceId, String currentDate);
}

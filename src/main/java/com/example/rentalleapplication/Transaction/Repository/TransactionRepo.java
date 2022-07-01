package com.example.rentalleapplication.Transaction.Repository;

import com.example.rentalleapplication.Transaction.Model.TransactionPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepo  implements ITransactionRepo{
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public TransactionPojo getTransactionIdAndAmountByProductId(int id, String amount) {
        String sql = "SELECT ID as pId,SellerID ,PricePerMonth as amount,TotalProduct from Product where ID = ?";
        return (TransactionPojo)  jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(TransactionPojo.class));
    }

    @Override
    public void initiateTransaction(TransactionPojo txnProduct, int userId, int sellerID, String referenceId, String currentDate) {

        String sql = "INSERT into Orders (ProductID,UserID,SellerID,Amount,TransactionStatus,ReferenceID,CreatedDate) values (?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[]{
                txnProduct.getPId(),userId,sellerID,txnProduct.getAmount(),txnProduct.getAmount(),referenceId,currentDate
        });
    }
}

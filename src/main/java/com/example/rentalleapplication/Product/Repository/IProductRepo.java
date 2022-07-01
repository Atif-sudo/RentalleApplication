package com.example.rentalleapplication.Product.Repository;

import com.example.rentalleapplication.Product.Model.EmailPojo;
import com.example.rentalleapplication.Product.Model.ProductUploadData;
import com.example.rentalleapplication.Product.Model.ProductsPojo;
import com.example.rentalleapplication.Product.Model.RentedProducts;
import com.example.rentalleapplication.Transaction.Model.TransactionPojo;
import com.example.rentalleapplication.Transaction.Service.ProductDataForTransaction;

import java.util.List;

public interface IProductRepo {




    void setProductData(ProductUploadData productUploadData);

    List<ProductsPojo> getProductList(int categoryId, int limit);

    void updateTotalProductAndAvailability(int pId, boolean availibility);


    ProductDataForTransaction getAllDataByProductId(int pId);

    void updateRentedProductTable(TransactionPojo txnProduct, int userId,int sellerID,String currentDate,String dueDate);

    List<RentedProducts> getRentedProductsByUserId(int id);

    List<RentedProducts> getSelledProductsBySellerID(int id);

    List<EmailPojo> getEmailByUserId(int id);

    List<EmailPojo> getEmailBySellerId(int id);
}

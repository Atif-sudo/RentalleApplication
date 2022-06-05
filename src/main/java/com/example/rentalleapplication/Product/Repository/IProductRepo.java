package com.example.rentalleapplication.Product.Repository;

import com.example.rentalleapplication.Product.Model.ProductUploadData;
import com.example.rentalleapplication.Product.Model.ProductsPojo;

import java.util.List;

public interface IProductRepo {




    void setProductData(ProductUploadData productUploadData);

    List<ProductsPojo> getProductList(int categoryId, int limit);
}

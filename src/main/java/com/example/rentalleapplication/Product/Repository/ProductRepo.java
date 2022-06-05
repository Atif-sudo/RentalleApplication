package com.example.rentalleapplication.Product.Repository;

import com.example.rentalleapplication.Product.Model.ProductUploadData;
import com.example.rentalleapplication.Product.Model.ProductsPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo  implements IProductRepo{


    @Autowired
    JdbcTemplate jdbcTemplate;

    public  void main(String[] args) {

    }

    @Override
    public void setProductData(ProductUploadData productUploadData) {
        String sqlQuery = "INSERT INTO Product (CategoryID, ProductName, ProductDescription, TotalProduct, PricePerMonth, StatusAvailibility,SellerID) VALUES (?,?,?,?,?,?,?)";

        jdbcTemplate.update(
                sqlQuery,
                new Object[]{productUploadData.getCategoryID(),
                        productUploadData.getProductName(),
                        productUploadData.getProductDescription(),
                        productUploadData.getTotalProduct(),
                        productUploadData.getPricePerMonth(),
                         productUploadData.getTotalProduct()  > 0 ? true : false,
                        productUploadData.getSellerID()

                });
    }

    @Override
    public List<ProductsPojo> getProductList(int categoryId, int limit) {
        String Sql = "select p.ID as productId,p.CategoryID ,p.SubCategoryID,sc.SubCategoryName,p.ProductName,p.ProductDescription ,p.PricePerMonth ,p.StatusAvailibility  from Category c ,Product p ,SubCategory sc where p.CategoryID = c.ID and p.SubCategoryID  = sc.ID  and c.ID = ? limit ?";
        List<ProductsPojo> productsPojoList;
        productsPojoList = jdbcTemplate.query(Sql, new Object[] {categoryId,limit}, new BeanPropertyRowMapper<>(ProductsPojo.class));

        return productsPojoList;
    }


}

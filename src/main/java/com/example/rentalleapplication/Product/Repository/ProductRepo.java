package com.example.rentalleapplication.Product.Repository;

import com.example.rentalleapplication.Product.Model.EmailPojo;
import com.example.rentalleapplication.Product.Model.ProductUploadData;
import com.example.rentalleapplication.Product.Model.ProductsPojo;
import com.example.rentalleapplication.Product.Model.RentedProducts;
import com.example.rentalleapplication.Transaction.Model.TransactionPojo;
import com.example.rentalleapplication.Transaction.Service.ProductDataForTransaction;
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
        String sqlQuery = "INSERT INTO Product (CategoryID, ProductName, ProductDescription, TotalProduct, PhotoUpload,PricePerMonth, StatusAvailibility,SellerID) VALUES (?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(
                sqlQuery,
                new Object[]{productUploadData.getCategoryID(),
                        productUploadData.getProductName(),
                        productUploadData.getProductDescription(),
                        productUploadData.getTotalProduct(),
                        productUploadData.getPhotoUpload(),
                        productUploadData.getPricePerMonth(),
                         productUploadData.getTotalProduct()  > 0 ? true : false,
                        productUploadData.getSellerID()

                });
    }

    @Override
    public List<ProductsPojo> getProductList(int categoryId, int limit) {
        String Sql = "select p.ID as productId,p.CategoryID ,p.SubCategoryID,p.ProductName,p.ProductDescription, p.PhotoUpload ,p.PricePerMonth ,p.StatusAvailibility  from Category c ,Product p where p.CategoryID = c.ID  and c.ID = ? limit ?";
        List<ProductsPojo> productsPojoList;
        productsPojoList = jdbcTemplate.query(Sql, new Object[] {categoryId,limit}, new BeanPropertyRowMapper<>(ProductsPojo.class));

        return productsPojoList;
    }


    @Override
    public void updateTotalProductAndAvailability(int pId, boolean availibility) {
            String sql = "update Product set TotalProduct = TotalProduct - 1, StatusAvailibility = ? where ID = ?";
            jdbcTemplate.update(sql,new Object[]{availibility,pId});
    }


    @Override
    public ProductDataForTransaction getAllDataByProductId(int pId) {
        String sql = "SELECT * from Product where ID = ?";

        return (ProductDataForTransaction) jdbcTemplate.queryForObject(sql,new Object[]{pId}, new BeanPropertyRowMapper<>(ProductDataForTransaction.class));
    }

    @Override
    public void updateRentedProductTable(TransactionPojo txnProduct, int userId, int sellerID, String currentDate, String dueDate) {
            String sql = "INSERT into RentedProducts (ProductID,CustomerID,SellerID,RentedDate,DueDate) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{txnProduct.getPId(),userId,sellerID,currentDate,dueDate});

    }

    @Override
    public List<RentedProducts> getRentedProductsByUserId(int id) {
        List<RentedProducts> rentedProducts;
        String sql = "SELECT DISTINCT (ProductName),rp.RentedDate, u.Email,rp.DueDate,rp.SellerID as id FROM  Product p, Users u , Orders o ,RentedProducts rp where o.ProductID = p.ID and o.UserID = u.ID and  rp.ProductID = p.ID and rp.CustomerID = u.ID and u.ID = ?";
        rentedProducts = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper<>(RentedProducts.class));
        return rentedProducts;
    }

    @Override
    public List<RentedProducts> getSelledProductsBySellerID(int id) {
        List<RentedProducts> rentedProducts;
        String sql = "SELECT ProductName,rp.RentedDate, u.Email,rp.DueDate,rp.CustomerID as id FROM  Product p, Users u , RentedProducts rp where p.SellerID = u.ID and rp.ProductID  = p.ID and rp.SellerID = u.ID  and u.ID = ?";
       rentedProducts = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper<>(RentedProducts.class));
        return rentedProducts;
    }

    @Override
    public List<EmailPojo> getEmailByUserId(int id) {
    List<EmailPojo> emails;
        String sql = "select u.Email,u.ID from Users u where u.ID IN (select SellerID from RentedProducts rp where CustomerID = ?)";
        emails = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper<>(EmailPojo.class));
        return emails;
    }

    @Override
    public List<EmailPojo> getEmailBySellerId(int id) {
        List<EmailPojo> emails;
        String sql = "select u.Email,u.ID  from Users u where u.ID IN (select CustomerID from RentedProducts rp where SellerID = ?)";
        emails = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper<>(EmailPojo.class));
        return emails;
    }


}

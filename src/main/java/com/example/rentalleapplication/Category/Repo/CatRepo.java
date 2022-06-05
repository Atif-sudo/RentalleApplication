package com.example.rentalleapplication.Category.Repo;

import com.example.rentalleapplication.Authentication.Models.LoginDbData;
import com.example.rentalleapplication.Category.Model.CategoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepo  implements  ICatRepo{


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CategoryData> getCategoriesFromDb() {
        String sqlQuery = "SELECT * from Category";

        return  jdbcTemplate.query(
                sqlQuery,
                new BeanPropertyRowMapper(CategoryData.class));
    }
}

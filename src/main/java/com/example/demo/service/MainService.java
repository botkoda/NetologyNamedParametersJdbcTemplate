package com.example.demo.service;

import com.example.demo.repo.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MainService {
    MainRepository mainRepository;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;

    }

    public String getProductName(String name) {
        Product product=namedParameterJdbcTemplate.queryForObject(mainRepository.getReadMyScript(),
                Map.of("customer_name",""+name),
                (resultSet,i)->new Product(resultSet.getString("product_name")));
        return  product.toString();
    }

    public static class Product{
        private String name;

        public Product(String name){
            this.name=name;

        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}

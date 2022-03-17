package com.example.demo.service;

import com.example.demo.repo.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MainService {
    private MainRepository mainRepository;


    public MainService(MainRepository mainRepository, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.mainRepository = mainRepository;
    }

    public List<String> getProductNameFromRepository(String name) {
        final List<String> productName = mainRepository.getProductName(name);
        return productName;
    }

}

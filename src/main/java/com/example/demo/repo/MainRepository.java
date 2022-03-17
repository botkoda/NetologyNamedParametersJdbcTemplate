package com.example.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MainRepository {
    private String readMyScript;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MainRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;

    }

    public List<String> getProductName(String name) {
        final List<String> product = namedParameterJdbcTemplate.queryForList(getReadMyScript(),
                Map.of("customer_name", "" + name),
                String.class);
        return product;
    }

    public String getReadMyScript() {
        readMyScript = read("/myScript.sql");
        return readMyScript;
    }

    public String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}

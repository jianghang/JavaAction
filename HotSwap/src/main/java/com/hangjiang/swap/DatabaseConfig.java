package com.hangjiang.swap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by jianghang on 2017/7/10.
 */
@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource_src(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=utf8");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("admin");

        return driverManagerDataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource_src());

        return jdbcTemplate;
    }
}

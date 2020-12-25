package com.trainticket.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author user
 * @Date 2020/12/25 2:28 PM
 * @Version 1.0
 */
@Configuration
@PropertySource("classpath:datasource.properties")
@MapperScan(basePackages = {"com.trainticket.dao.login"}, sqlSessionTemplateRef = "loginDBSessionTemplate")
public class LoginDBConfig {
    @Bean
    @ConfigurationProperties(prefix = "datasource.db2")
    public DataSource loginDBDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public DataSourceTransactionManager loginDBTransactionManager(@Qualifier("loginDBDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory loginDBSessionFactory(@Qualifier("loginDBDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mappers/login/*.xml")
        );
        return sessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate loginDBSessionTemplate(@Qualifier("loginDBSessionFactory") SqlSessionFactory sessionFactory){
        return new SqlSessionTemplate(sessionFactory);
    }
}

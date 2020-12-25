package com.trainticket.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author user
 * @Date 2020/12/25 2:12 PM
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.trainticket.dao.main"}, sqlSessionTemplateRef = "mainDBSessionTemplate")
public class MainDBConfig {
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
    public DataSource mainDBDataSource(){
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager mainDBTransactionManager(@Qualifier("mainDBDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionFactory mainDBSessionFactory(@Qualifier("mainDBDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mappers/main/*.xml")
        );
        return sessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate mainDBSessionTemplate(@Qualifier("mainDBSessionFactory") SqlSessionFactory sessionFactory){
        return new SqlSessionTemplate(sessionFactory);
    }
}

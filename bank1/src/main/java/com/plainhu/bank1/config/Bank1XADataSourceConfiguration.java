package com.plainhu.bank1.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.xa.DataSourceProxyXA;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @date: 2021-03-02 16:22:05
 * @author: hkt
 * @desc:
 */
@Configuration
public class Bank1XADataSourceConfiguration {

    @Bean("dataSourceProxy")
    public DataSource dataSource(DataSourceProperties properties) {
        // DataSourceProxy for AT mode
        // return new DataSourceProxy(druidDataSource);
        HikariDataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();

        // DataSourceProxyXA for XA mode
        return new DataSourceProxyXA(dataSource);
    }

}

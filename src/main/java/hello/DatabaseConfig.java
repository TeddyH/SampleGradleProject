package hello;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * Created by Administrator on 2014-12-29.
 */
@Configuration
@MapperScan(basePackages = "hello.repository.mybatis.mapper"/*, sqlSessionFactoryRef = "mySessionFactory"*/)
public class DatabaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Autowired
    private MybatisProperties mybatisProperties;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(mybatisProperties.getDriverClassName());
        dataSource.setUsername(mybatisProperties.getUserName());
        dataSource.setPassword(mybatisProperties.getPassword());
        dataSource.setUrl(mybatisProperties.getUrl());
        return dataSource;
    }

    public void printDataSourceStats(DataSource dataSource) {
        BasicDataSource bds = (BasicDataSource) dataSource;
        logger.info("NumActive : " + bds.getNumActive());
        logger.info("NumIdle : " + bds.getNumIdle());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean.getObject();
    }
}

package hello.repository.mybatis;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * Created by Administrator on 2014-12-29.
 */
@Configuration
//@EnableTransactionManagement
@MapperScan(basePackages = "hello.repository.mybatis.mapper")
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
        dataSource.setValidationQuery("/* ping */ SELECT 1");
        // optional
//        dataSource.setMaxIdle(3);
//        dataSource.setTestOnBorrow(false);
//        dataSource.setTestOnReturn(false);
//        dataSource.setTestWhileIdle(true);
//        dataSource.setTimeBetweenEvictionRunsMillis(60000);
//        dataSource.setNumTestsPerEvictionRun(5);
//        dataSource.setMinEvictableIdleTimeMillis(-1);

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

        // TODO : teddy : mybatis-config.xml 을 사용 하는 경우
//        sessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sessionFactoryBean.setFailFast(true);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        sessionFactoryBean.setTypeHandlersPackage("hello.domain.*");

        return sessionFactoryBean.getObject();
    }

    // TODO : teddy : transactionManager 를 선언 하지 않아도 transaction 처리가 되더라..
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
}

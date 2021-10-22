package org.impelsys.SpringBootDemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DbConfig {
	
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String dialect;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddlAuto;
	
	
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource =new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("org.impelsys.SpringBootDemo.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager tansactionManager=
				new HibernateTransactionManager();
		tansactionManager.setSessionFactory(sessionFactory().getObject());
		return tansactionManager;
	}
	private final Properties hibernateProperties() {
		Properties hibernateProperties=new Properties();
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
		hibernateProperties.setProperty("hibernate.dialect", dialect);
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		return hibernateProperties;
		
		}
}

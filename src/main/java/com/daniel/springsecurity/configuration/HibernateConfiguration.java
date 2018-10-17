package com.daniel.springsecurity.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.*;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import com.daniel.springsecurity.model.extra.Post;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.daniel.springsecurity" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {
	
	
    @Autowired
    private Environment environment;

    @Bean
    public SessionFactory seshFactory() {
    	LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
                    builder.scanPackages(new String[] {"com.daniel.springsecurity.model.extra"}/*, "com.daniel.springsecurity.extra"}*/)
                    .addPackages("com.daniel.springsecurity.extra")     
                    
                    		/*.addAnnotatedClass(Friend.class)
                    		.addAnnotatedClass(Post.class)*/
                          .addProperties(hibernateProperties());

                    return builder.buildSessionFactory();
    	
    }
    
    
   /* @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {  "com.daniel.springsecurity.model.extra" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }*/
	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;        
    }
    
	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
			return new HibernateTransactionManager(seshFactory());
		
       /*HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;*/
    }
	
	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"com.daniel.springsecurity.extra"});
		
		JpaVendorAdapter vendorAdapter = new JpaVendorAdapter();
		
		
		return em;
		
	}*/
}


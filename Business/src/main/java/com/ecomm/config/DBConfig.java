package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.CategoryDAOImpl;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.ProductDAOImpl;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.dao.SupplierDAOImpl;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.dao.UserDetailDAOImpl;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.UserDetail;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	
	
// create a datasource object
	@Bean(name="dataSource")
public DataSource getH2DataSource()
{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUsername("dteja");
	dataSource.setPassword("dteja");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test2");
	System.out.println("=====create a datasource object===========");
	return dataSource;
}
	//create a session factory object
   @Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
	Properties hibernateProperties=new Properties();
	hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

	LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
	factory1.addProperties(hibernateProperties);
	factory1.addAnnotatedClass(Category.class);
	factory1.addAnnotatedClass(Supplier.class);
	factory1.addAnnotatedClass(Product.class);
	factory1.addAnnotatedClass(UserDetail.class);
	SessionFactory sessionFactory=factory1.buildSessionFactory();
	System.out.println("=====create a sessionFactory object===========");
	return sessionFactory;
	}
   @Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("----Category DAO Implementation---");
		return new CategoryDAOImpl();
	}
   
   @Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("----Supplier DAO Implementation---");
		return new SupplierDAOImpl();
	}
   
   @Bean(name="ProductDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("----Product DAO Implementation---");
		return new ProductDAOImpl();
	}  

   @Bean(name="userDetailDAO")
	public UserDetailDAO getUserDetailDAO()
	{
		System.out.println("----Product DAO Implementation---");
		return new UserDetailDAOImpl();
	}  
	

// create a hibernate transaction manager
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("=====create a transcationmanager object===========");
		return new HibernateTransactionManager(getSessionFactory());
	}
}

package com.ecomm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOUnitTestCases {
	static ProductDAO productDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	/*@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(2);
		product.setSupplierId(2);
		product.setCategoryId(2);
		product.setPrice(9000);
		product.setStock(50);
		product.setProductName("xiaomi redmi 4 ");
		product.setProductDesc("with snapdragon 435 processor and 13 mp camera ");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
	}*/
	
	
	/*@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(5));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(2);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}*/
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(9);
		product.setPrice(5000);
		product.setStock(40);
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
    @Ignore
	@Test
	public void listProductTest()
	{   
		List<Product> listProducts=productDAO.listProducts();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getStock()+":::");
			System.out.print(product.getPrice()+":::");
			System.out.println(product.getProductDesc());
		}
	}


}

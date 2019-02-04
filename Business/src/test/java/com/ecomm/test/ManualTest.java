package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*import com.ecomm.dao.ProductDAO;*/
/*import com.ecomm.model.Product;*/

/*import com.ecomm.dao.CategoryDAO;*/
import com.ecomm.dao.SupplierDAO;
/*import com.ecomm.model.Category;*/
import com.ecomm.model.Supplier;

public class ManualTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		/*CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		Category category=new Category();
		category.setCategoryName("samsung");
		category.setCategoryDesc("All Variety of Samsung ");
		
		categoryDAO.addCategory(category);*/
		
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
		Supplier supplier=new Supplier();
		supplier.setSupplierName("ABC Retailer");
		supplier.setSupplierDesc(" supplying samsung mobile ");
		supplierDAO.addSupplier(supplier);
		
		/*ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		
		Product product=new Product();
		product.setProductId(1);
		product.setSupplierId(1);
		product.setCategoryId(1);
		product.setPrice(1000);
		product.setStock(19);
		product.setProductName("The Job");
		product.setProductDesc("Colin Winnette");
		productDAO.addProduct(product);*/
	}

}

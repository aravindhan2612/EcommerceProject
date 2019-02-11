package com.ecomm.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
      Product product=new Product();
      m.addAttribute(product);
      m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
      m.addAttribute("productList",productDAO.listProducts());
      return "Product";
		
}

	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,Model m)
	{
		Product product1=new Product();
		m.addAttribute(product1);
		productDAO.addProduct(product);
		m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("productList",productDAO.listProducts());
		return "InsertingProduct";	
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")

	public String deleteProduct(@PathVariable("producyId")int productId,Model m)
	{
		Product product1=productDAO.getProduct(productId);
		productDAO.deleteProduct(product1);
		return "deleteProduct";
	}
	
	

	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		
		LinkedHashMap<Integer,String> listCategory=new LinkedHashMap<Integer,String>();
		for(Category category:categoryList)
		{
			listCategory.put(category.getCategoryId(),category.getCategoryName());
		}
		return listCategory;
	}
		
		
		
	

}
package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.UserDetail;

public class UserDetailDAOUnitTestCases {
	static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	}
	
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
	
		user.setMobileNo("9876543211");
		user.setPassword("dteja");
		user.setUsername("dteja");
		user.setAddr("chennai");
		user.setRole("Admin");
		user.setCustomerName("aravind");
		
		assertTrue("Problem in User Insertion",userDetailDAO.registerUser(user));
	}
	/*@Test
	public void updateUserTest()
	{
		UserDetail user=userDetailDAO.getUserId(1);
	    user.setUsername("The Admin");
		assertTrue("Problem in Updation",userDetailDAO.updateUser(user));
	}*/
	
	
	@Ignore
	@Test
	public void listUserTest()
	{
		List<UserDetail> listUserDetails=userDetailDAO.getUserDetails();
		assertNotNull("No User",listUserDetails);
		
		for(UserDetail user:listUserDetails)
		{
			System.out.print(user.getUsername()+":::");
			System.out.print(user.getMobileNo()+":::");
			
		}
	}
	
	
}

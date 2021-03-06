package com.ecomm.dao;

import java.util.List;

import org.h2.engine.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Category;
import com.ecomm.model.UserDetail;

@Repository("userDetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO{
	@Autowired
     SessionFactory sessionFactory;
	public boolean registerUser(UserDetail userDetail) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(userDetail);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteUser(UserDetail userDetail) {
		try
		{
		sessionFactory.getCurrentSession().delete(userDetail);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateUser(UserDetail userDetail) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(userDetail);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public UserDetail getUserId(int userId) {
		Session session=sessionFactory.openSession();
		UserDetail user=(UserDetail)session.get(UserDetail.class,userId);
		session.close();
		return user;
		
	}

	public List<UserDetail> getUserDetails() {
		
		Session session=sessionFactory.openSession();
		List<UserDetail> listUserDetails=(List<UserDetail>)session.createQuery("from UserDetail").list();
		session.close();
		return listUserDetails;
	}
	
	

}

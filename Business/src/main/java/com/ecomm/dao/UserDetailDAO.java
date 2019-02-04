package com.ecomm.dao;

import java.util.List;

import org.h2.engine.User;

import com.ecomm.model.UserDetail;

public interface UserDetailDAO {
	public boolean registerUser(UserDetail userDetail);
	public boolean deleteUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUserId(int userId);
	public List<UserDetail> getUserDetails();

}

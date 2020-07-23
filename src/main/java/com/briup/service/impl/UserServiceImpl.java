package com.briup.service.impl;


import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.User;

import com.briup.dao.UserDao;
import com.briup.service.IUserService;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年3月26日 下午4:51:26 
* 类说明 
*/
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User findByName(String name) {
		return dao.findByName(name);
	}
	@Override
	public void saveUser(User user) {
		dao.save(user);
		
	}

	@Override
	public void deleteUser(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public User findUserById(Integer id) {
		return dao.getOne(id);
		
	}

	@Override
	public Page<User> findAllUser(Integer rid,Integer pageIndex) {
		if(rid==null) {
			return dao.findAll(PageRequest.of(pageIndex, 1));
		}else{
			Role role = new Role();
			role.setId(rid);
			return  dao.findByRole(role,PageRequest.of(pageIndex, 1));
		}
		
	}
	@Override
	public Page<User> findAllUser(Integer rid) {
		
		return findAllUser(rid, 0);
	}

}

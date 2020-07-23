package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.dao.RoleDao;
import com.briup.service.IRoleService;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年3月27日 下午2:42:55 
* 类说明 
*/
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleDao dao;
	
	@Override
	public List<Role> findAllRoles() {
		return dao.findAll();
	}

	@Override
	public Page<Role> findAllRoles(Integer pageIndex) {
		Page<Role> page = dao.findAll(PageRequest.of(pageIndex, 2));
		return page;
	}

	@Override
	public void saveRole(Role role) {
		dao.save(role);
	}

	@Override
	public void deleteRole(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Role findRoleById(Integer id) {
		return dao.getOne(id);
	}

}

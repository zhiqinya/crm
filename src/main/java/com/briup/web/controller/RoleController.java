package com.briup.web.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.service.IRoleService;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年3月27日 上午11:51:05 
* 类说明 角色管理模块
*/
@Controller
public class RoleController {
	
	@Autowired
	private IRoleService service;
	//第一页
	@RequestMapping("toRole")
	public String toRole(HttpSession session) {
		//将数据库中所有信息查询出来保存到session中
		Page<Role> roles = service.findAllRoles(0);
		session.setAttribute("roles", roles);
		return "pages/role";
	}
	//新增修改
	@RequestMapping("saveRole")
	@ResponseBody
	public String roles(Role role) {
		if(role.getId()!=null) {			
			service.saveRole(role);
			return"修改成功";
		}else {
			service.saveRole(role);
			return"添加成功";
		}
	}
	//删除
	@RequestMapping("delete")
	@ResponseBody
	public String delete(int n) {
		service.deleteRole(n);
		return"删除成功";
	}
	//指定页
	@RequestMapping("pageRole")
	public String updatePageRole(Integer pageIndex,HttpSession session) {
		Page<Role> roles = service.findAllRoles(pageIndex);
		session.setAttribute("roles", roles);
		return "pages/role";
	}
	@RequestMapping("findRoleById")
	@ResponseBody
	public Role findRoleById(Integer id) {
		Role role = service.findRoleById(id);
		
		return role;
	}
	
}

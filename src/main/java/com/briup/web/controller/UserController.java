package com.briup.web.controller;



import java.util.List;


import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.bean.User;

import com.briup.service.impl.RoleServiceImpl;
import com.briup.service.impl.UserServiceImpl;


/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年3月26日 下午4:33:10 
* 类说明 
*/
@Controller
public class UserController {

	@Autowired
	private UserServiceImpl service;
	@Autowired
	private RoleServiceImpl service2;
	
	//获取前台输入的用户名密码 验证
	@RequestMapping("user/login")
	@ResponseBody
	public String login(String name,String password,HttpSession session) {
		//判断用户名密码是否存在
		User user = service.findByName(name);
		if(user==null) {
			return"当前用户不存在";
		}
		if(!user.getPassword().equals(password)){
			return"密码错误";
		}
		if(user.getFlag()!=1){
			return"用户已被注销";
		}
		System.out.println(user);
		//将数据保存在session范围中供前台使用
		session.setAttribute("user", user);
		
		return "success";
	}
	@RequestMapping("logout")
	public String lohout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	@RequestMapping("toUser")
	public String touser(HttpSession session,Integer rid) {
		session.setAttribute("rid", rid);
		Page<User> users = service.findAllUser(rid);	
		session.setAttribute("users",users);
		List<Role> roles = service2.findAllRoles();
		session.setAttribute("roles", roles);
		return "pages/user";
	}
	@RequestMapping("saveUser")
	@ResponseBody
	public String saveuser(User user) {
		service.saveUser(user);
		return "保存成功";
	}
	@RequestMapping("deleteUser")
	@ResponseBody
	public String delete(Integer id) {
		service.deleteUser(id);
		return "删除成功";
	}
	@RequestMapping("pageUser")
	public String pageUser(Integer pageIndex,HttpSession session) {
		Integer rid = (Integer) session.getAttribute("rid");
		Page<User> users = service.findAllUser(rid,pageIndex);
		session.setAttribute("users", users);
		return"pages/user";
	}
	/*
	 * @RequestMapping(value = "user/{id}" , method = RequestMapping.get); public
	 * User setuser(@PathVariable Integer id) {
	 * 
	 * return service.findUserById(id); }
	 */
	@RequestMapping("getUser")
	@ResponseBody
	public User setuser(Integer id) {
		System.out.println(id);
		return 	service.findUserById(id);
	}
}

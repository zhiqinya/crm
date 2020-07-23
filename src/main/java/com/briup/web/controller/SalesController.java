package com.briup.web.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.service.SalesService;
import com.briup.service.impl.UserServiceImpl;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月1日 下午8:10:46 
* 类说明 
*/
@Controller
public class SalesController {
	
	@Autowired
	private SalesService serivce;
	@Autowired
	private UserServiceImpl service2;
	@RequestMapping("toSales")
	public String toSale(HttpSession session,String address,String customer) {
		
		session.setAttribute("address", address);
		session.setAttribute("customer", customer);
		Page<User> users = service2.findAllUser(4);
		Page<Chance> chances = serivce.findAllchance(address, customer);
		session.setAttribute("chances", chances);
		session.setAttribute("users", users);
		return "pages/sales";
	}
	@RequestMapping("getchance")
	@ResponseBody
	public String getchance(Chance chance) {
		if(chance.getId()==null) {
			serivce.saveChance(chance);
			return "保存成功";
		}else {
			serivce.saveChance(chance);
			return "修改成功";
		}
	
	}
	@RequestMapping("deletechance")
	@ResponseBody
	public String delete(Integer id) {
		serivce.deleteChance(id);
		return "删除成功";
	}
	@RequestMapping("getchanceById")
	@ResponseBody
	public Chance chance(Integer id) {
		return 	serivce.findChanceById(id);
	}
	
	@RequestMapping("selectPage")
	public String select(Integer index,HttpSession session) {
		String address = (String) session.getAttribute("address");
		String customer = (String) session.getAttribute("customer");
		Page<Chance> chances = serivce.findAllchance(index, address, customer);
		session.setAttribute("chances", chances);
		return "pages/sales" ;
	}
	@RequestMapping("remove")
	public String remove(HttpSession session) {
		session.removeAttribute("address");
		session.removeAttribute("customer");
		return "pages/sales" ;
	}
}

package com.briup.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Plan;
import com.briup.service.PlanServiceImpl;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月1日 下午7:03:43 
* 类说明 
*/
@Controller
public class PlanController {
	@Autowired
	private PlanServiceImpl service;
	@RequestMapping("toPlan")
	public String toplan(HttpSession session) {
	
		return "pages/plan";
	}
}

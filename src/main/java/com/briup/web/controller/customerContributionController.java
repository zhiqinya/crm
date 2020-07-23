package com.briup.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.briup.bean.CustomerContribution;
import com.briup.service.ICustomerContributionSercvice;

@Controller
public class customerContributionController {
	@Autowired
	private ICustomerContributionSercvice service;
	
	@RequestMapping("tocustomerContribution")
	public String tocustomerContribution() {
		return "pages/customerContribution";
	}
	@RequestMapping("level")
	@ResponseBody
	public List<CustomerContribution> tolevel(String level){
		List<CustomerContribution> list = service.level(level);
		System.out.println(list);
		return list;
	}
}

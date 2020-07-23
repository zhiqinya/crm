package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CustomerConstitute;
import com.briup.bean.User;
import com.briup.dao.CustomerDao;
import com.briup.dao.SaleDao;
import com.briup.dao.UserDao;
import com.briup.service.ICustomerConstituteService;
import com.briup.service.IUserService;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月3日 上午10:46:48 
* 类说明 
*/
@Service
public class CustomerConstituteServiceImpl implements ICustomerConstituteService {
	
	
	@Autowired
	private CustomerDao dao;
	
	@Override
	public List<CustomerConstitute> regionAnalyze() {
		float size = dao.findAll().size();
		
		List<CustomerConstitute> list = new ArrayList<CustomerConstitute>();
		String arr[] = {"华中","华南","华北","华东"};
		for (int i = 0; i < arr.length; i++) {
			float size2 = dao.findByRegion(arr[i]).size();
			CustomerConstitute constitute = new CustomerConstitute(arr[i],size2/size*100,arr[i]);
			list.add(constitute);
		}
		System.out.println(list);
		return list;
	}

	@Override
	public List<CustomerConstitute> levelAnalyze() {
		float size = dao.findAll().size();
		String[] levels = {"普通客户","大客户","重点客户","合作伙伴","战略合作伙伴"};
		List<CustomerConstitute> list = new ArrayList<CustomerConstitute>();
		for (String level : levels) {
			float size2 = dao.findByLevel(level).size();
			float num = size2/size*100;
			CustomerConstitute constitute = new CustomerConstitute(level, num, level);
			list.add(constitute);
		}
		System.out.println(list);
		return list;
	}

}

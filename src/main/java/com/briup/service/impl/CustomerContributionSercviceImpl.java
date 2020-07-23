package com.briup.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Customer;
import com.briup.bean.CustomerContribution;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerContributionSercvice;

@Service
public class CustomerContributionSercviceImpl implements ICustomerContributionSercvice {

	@Autowired
	private CustomerDao dao;
	@Override
	public List<CustomerContribution> level(String level) {
		System.out.println(level);
		int allBankroll = 0;
		ArrayList<CustomerContribution> list = new ArrayList<CustomerContribution>();
		List<Customer> findByRegion = dao.findByRegion(level);
		System.out.println(findByRegion);
		for (Customer customer :findByRegion) {
			allBankroll += customer.getBankroll();
		}
		
		for (Customer customer : findByRegion) {
			String name = customer.getName();
			CustomerContribution contribution = new CustomerContribution(name, customer.getBankroll()/allBankroll*100,name);
			list.add(contribution);
		}
		return list;
	}

}

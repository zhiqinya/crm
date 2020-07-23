package com.briup.service;

import java.util.List;

import com.briup.bean.CustomerContribution;

public interface ICustomerContributionSercvice {
	List<CustomerContribution> level(String level);
}

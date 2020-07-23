package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.dao.SaleDao;
import com.briup.service.SalesService;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月1日 下午8:27:22 
* 类说明 
*/
@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SaleDao dao;

	@Override
	public Page<Chance> findAllchance(String address, String customer) {
		
		return findAllchance(0,address,customer);
	}

	@Override
	public Page<Chance> findAllchance(Integer pageIndex, String address, String customer) {
		
		customer = "".equals(customer)?null:customer;
		if (customer!=null && address!=null) {
			return dao.findByAddressAndCustomer(address, PageRequest.of(pageIndex, 1), customer);
		}else if (customer!=null && address==null) {
			return dao.findByCustomerLike("%"+customer+"%", PageRequest.of(pageIndex, 1));
			
		}else if (customer==null && address!=null) {
			return dao.findByAddress(address, PageRequest.of(pageIndex, 1));
		}else {
			return dao.findAll(PageRequest.of(pageIndex, 1));
		}
		
	}
	
	@Override
	public void saveChance(Chance chance) {
		dao.save(chance);
	}

	@Override
	public void deleteChance(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public Chance findChanceById(Integer id) {
		
		return dao.getOne(id);
	}


}

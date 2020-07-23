package com.briup.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Chance;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月1日 下午8:17:51 
* 类说明 
*/
public interface SaleDao extends JpaRepository<Chance, Integer> {
	Page<Chance> findByAddress(String address,Pageable page);
	Page<Chance> findByCustomer(String customer,Pageable page);
	Page<Chance> findByAddressAndCustomer(String address,Pageable page,String customer);
	
	Page<Chance> findByCustomerLike(String customer,Pageable page);
	List<Chance> findByAddress(String address);
	
	
}

package com.briup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Customer;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月3日 上午10:47:48 
* 类说明 
*/
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	List<Customer> findByRegion(String region);
	List<Customer> findByLevel(String level);
	
}

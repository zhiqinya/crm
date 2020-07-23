package com.briup.service;
/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月1日 下午8:24:58 
* 类说明 
*/

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;

public interface SalesService {
	Page<Chance> findAllchance(String address, String customer);
	Page<Chance> findAllchance(Integer pageIndex,String address,String customer);
	void saveChance(Chance chance);
	void deleteChance(Integer id);
	Chance findChanceById(Integer id);
	
}

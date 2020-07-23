package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Plan;
import com.briup.dao.PlanDao;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月1日 下午7:20:27 
* 类说明 
*/
@Service
public class PlanServiceImpl implements com.briup.service.PlanServiceImpl{
	@Autowired
	private PlanDao dao;
	@Override
	public Page<Plan> findAllPlan() {
		
		return findAllPlan(0);
	}

	@Override
	public Page<Plan> findAllPlan(Integer pageIndex) {
	
		return 	dao.findAll(PageRequest.of(pageIndex, 2));
	}

}

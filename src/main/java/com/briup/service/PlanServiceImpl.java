package com.briup.service;
/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月1日 下午7:13:51 
* 类说明 
*/

import org.springframework.data.domain.Page;

import com.briup.bean.Plan;

public interface PlanServiceImpl {
	Page<Plan> findAllPlan();
	Page<Plan> findAllPlan(Integer pageIndex);
}

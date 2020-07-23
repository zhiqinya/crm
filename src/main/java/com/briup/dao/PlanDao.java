package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Plan;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月1日 下午7:09:51 
* 类说明 
*/
public interface PlanDao extends JpaRepository<Plan, Integer> {

}

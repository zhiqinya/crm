package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Role;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年3月27日 下午2:43:30 
* 类说明  role 从数据库查找使用默认提供的方法
*/
public interface RoleDao extends JpaRepository<Role, Integer>{

}

package com.briup.service;
/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年3月27日 下午2:34:49 
* 类说明 
*/



import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Role;

public interface IRoleService {
	//查询刚进入模块所有角色
	List<Role> findAllRoles();
	
	//查询指定页上的数据信息
	Page<Role> findAllRoles(Integer pageIndex);
	
	//新增和修改
	void saveRole(Role role);
	
	//删除
	void deleteRole(Integer id);
	
	//通过id找到对应Role
	Role findRoleById(Integer id);
	
}

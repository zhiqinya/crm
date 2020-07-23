package com.briup.service;





import java.util.Optional;



import org.springframework.data.domain.Page;


import com.briup.bean.User;


/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年3月26日 下午4:48:00 
* 类说明 
*/
public interface IUserService {
	User findByName(String name);
	//查询刚进入模块所有角色
		Page<User> findAllUser(Integer rid,Integer pageIndex);
		
		//查询指定页上的数据信息
		Page<User> findAllUser(Integer rid);
		
		//新增和修改
		void saveUser(User user);
		
		//删除
		void deleteUser(Integer id);
		
		//通过id找到对应User
		User findUserById(Integer id);
		
		
		
}

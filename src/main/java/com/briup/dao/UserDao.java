package com.briup.dao;



import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.briup.bean.Role;
import com.briup.bean.User;

/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年3月26日 下午4:54:43 
* 类说明 
*/
public interface UserDao extends JpaRepository<User, Integer> {

	User findByName(String name);
	Page<User> findByRole(Role role,Pageable page);
	@Modifying
	@Transactional
	@Query("delete from User user where user.id=?1")
	void deleteUserById(Integer id);
}

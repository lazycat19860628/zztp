package com.example.demo.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.sec.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{
	

	SysUser findByUsername(String username);
	
	SysUser findByUsernameAndPassword(String username,String password);
	
	@Query("select p from SysUser p where p.username= :username and p.password= :password")
	
	SysUser withUsernameAndPasswordQuery(@Param("username")String username,@Param("password")String password);
	
	SysUser withUsernameAndPasswordNamedQuery(String username,String password);
	

}

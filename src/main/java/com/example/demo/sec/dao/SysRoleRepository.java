package com.example.demo.sec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.sec.domain.SysRole;


public interface SysRoleRepository  extends JpaRepository<SysRole, Long> {
	
	//List<SysRole> findByName(String name);
	SysRole findByName(String name);
	List<SysRole> findByNameLike(String name);

   
	@Query("select p from SysRole p where p.name= :name ")
	
	SysRole withNameQuery(@Param("name")String name);
	
	SysRole withNameNamedQuery(String name);

}
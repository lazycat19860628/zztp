package com.example.demo.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sec.dao.SysRoleRepository;
import com.example.demo.sec.dao.SysUserRepository;
import com.example.demo.sec.domain.SysRole;


@Service
public class RoleService {
	@Autowired
	SysRoleRepository sysRoleRepository;
	@Autowired
	SysUserRepository sysUserRepository;
	public List<SysRole> roles(Long id){
		List<SysRole> roles = sysRoleRepository.findAll();
		List<SysRole> useroles = sysUserRepository.findById(id).get().getRoles();
		for(int i=0;i<roles.size();i++){
			if(useroles.contains(roles.get(i))){
				roles.get(i).setChecked("true");
			}
			else{
				roles.get(i).setChecked("false");
			}
		}
		return roles;
    }
	public List<SysRole> findAll(){
		List<SysRole> roles = sysRoleRepository.findAll();
		return roles;
    }
	public SysRole findById(Long id){
		SysRole roles = sysRoleRepository.findById(id).get();
		return roles;
    }
	public SysRole findByName(String name){
		SysRole roles = sysRoleRepository.findByName(name);
		return roles;
		}
		public List<SysRole> findByNameLike(String name){
			List<SysRole> roles = sysRoleRepository.findByNameLike(name);
			return roles;
			}
	public void save(Long id,String name,String action){
		if (action.contains("create") ){
			SysRole sysRole =new SysRole();
			sysRole.setName(name);	
			sysRoleRepository.save(sysRole);
				return ;
	}
	else if (action.contains("edit")){
		SysRole sysRole=sysRoleRepository.findById(id).get();
		sysRole.setName(name);	
		sysRoleRepository.save(sysRole);
			return ;
    }
	}
}

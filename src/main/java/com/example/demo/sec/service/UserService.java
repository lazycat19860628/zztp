package com.example.demo.sec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.sec.dao.SysRoleRepository;
import com.example.demo.sec.dao.SysUserRepository;
import com.example.demo.sec.domain.SysRole;
import com.example.demo.sec.domain.SysUser;

@Service
public class UserService {
	@Autowired
	SysRoleRepository sysRoleRepository;
	@Autowired
	SysUserRepository sysUserRepository;
	public SysUser findCurrentUser() {
	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		String username =userDetails.getUsername();
		SysUser sysUser=sysUserRepository.findByUsername(username);	
		return sysUser;
	}
	public List<SysUser> findAll() {
		List<SysUser> sysUser=sysUserRepository.findAll();
		return sysUser;
	}
	public SysUser findByUsername(String username) {
		SysUser sysUser=sysUserRepository.findByUsername(username);
		return sysUser;
	}
	public void save(Model model, Long id, String action, String username, String password, String[] roles){
		if (action.contains("create") ){
				SysUser sysUser =new SysUser();
				sysUser.setUsername(username);
				sysUser.setPassword(password);
				List<SysRole> roles1= new ArrayList<SysRole>();
					for(int i=0;i<roles.length;i++){
						SysRole sysRole =sysRoleRepository.findByName(roles[i]);
						roles1.add(sysRole);}
				sysUser.setRoles(roles1);
					sysUserRepository.save(sysUser);
					return ;
		}
		else if (action.contains("edit")){
			SysUser sysUser=sysUserRepository.findById(id).get();
			sysUser.setUsername(username);
			sysUser.setPassword(password);
			List<SysRole> roles1= new ArrayList<SysRole>();
				for(int i=0;i<roles.length;i++){
					SysRole sysRole =sysRoleRepository.findByName(roles[i]);
					roles1.add(sysRole);}
			sysUser.setRoles(roles1);
				sysUserRepository.save(sysUser);
				return ;
		}
		
		
		
		
	
    }
}

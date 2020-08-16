package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentResultDao;
import com.example.demo.dao.PersonRepoistory;
import com.example.demo.domain.CommentResult;
import com.example.demo.domain.Person;
import com.example.demo.sec.dao.SysUserRepository;
import com.example.demo.sec.domain.SysUser;

@Service
public class ResultService {
	@Autowired
	PersonRepoistory personRepoistory;
	@Autowired
	SysUserRepository sysUserRepository;
	@Autowired
	CommentResultDao commentResultDao;
	public List<CommentResult> result() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		String username =userDetails.getUsername();
		SysUser sysUser=sysUserRepository.findByUsername(username);	
		String name = personRepoistory.findBySysUser(sysUser).getName();

		return commentResultDao.CommentResult(name);
		
	}
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentTargetRepository;
import com.example.demo.domain.CommentTarget;
import com.example.demo.domain.Topic;
import com.example.demo.sec.dao.SysUserRepository;
import com.example.demo.sec.domain.SysUser;


@Service
public class CommentTargetService {
	@Autowired
	CommentTargetRepository repository;
	@Autowired
	SysUserRepository sysUserRepository;
	public List<CommentTarget> index(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		String username =userDetails.getUsername();
		SysUser sysUser=sysUserRepository.findByUsername(username);	
		return sysUser.getCommentTargets();	
	}
	public CommentTarget instance(Long id){
		
		CommentTarget commentTarget = repository.findById(id).get();
		
		return commentTarget;	
	}
	
}

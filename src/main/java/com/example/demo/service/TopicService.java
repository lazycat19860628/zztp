package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TopicRepository;
import com.example.demo.domain.CommentTarget;
import com.example.demo.domain.Topic;
import com.example.demo.sec.dao.SysUserRepository;
import com.example.demo.sec.domain.SysUser;


@Service
public class TopicService {
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	SysUserRepository sysUserRepository;
	public UserDetails getUserDetails() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		return userDetails;
	}
	public List<Topic> index(){
		UserDetails userDetails = getUserDetails();
		if(userDetails.getAuthorities().toString().contains("KP")) {
			return topicRepository.findByUserName(userDetails.getUsername());
		}
		return topicRepository.findByUserName(userDetails.getUsername());	
	}
	public Topic instance(Long id){
		UserDetails userDetails = getUserDetails();
		String username =userDetails.getUsername();
		SysUser sysUser=sysUserRepository.findByUsername(username);	
		Topic topic = topicRepository.findById(id).get();
		
		return topic;	
	}
	public void save(Topic topic){
		for(int i=0;i<topic.getCommentTargets().size();i++) {
			
			System.out.print(topic.getCommentTargets().get(i).getId());
			System.out.print(topic.getCommentTargets().get(i).getRealPoint());
			System.out.print(topic.getCommentTargets().get(i).getPoint());
		}
		return ;	
		 //topicRepository.save(topic);	
	}
	public void deleteById(Long id){
		 topicRepository.deleteById(id);	
	}

}

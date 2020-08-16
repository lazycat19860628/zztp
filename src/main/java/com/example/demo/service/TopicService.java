package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentRecordRepository;
import com.example.demo.dao.TopicRepository;
import com.example.demo.domain.CommentRecord;
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
	@Autowired
	CommentRecordRepository commentRecordRepository;

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
		SysUser sysUser=sysUserRepository.findByUsername(getUserDetails().getUsername());	
		List<CommentRecord> commentRecords= commentRecordRepository.findByTopicIdAndSysUserId(topic.getId(), sysUser.getId());
		for(int j=0;j<commentRecords.size();j++) {
			commentRecordRepository.delete(commentRecords.get(j));
		}
		for(int i=0;i<topic.getCommentTargets().size();i++) {
			CommentRecord commentRecord = new CommentRecord();
			commentRecord.setTopic(topic);
			commentRecord.setCommentTarget(topic.getCommentTargets().get(i));
			commentRecord.setSysUser(sysUserRepository.findByUsername(getUserDetails().getUsername()));
			commentRecord.setPoint(topic.getCommentTargets().get(i).getPoint());
			commentRecord.setRealPoint(topic.getCommentTargets().get(i).getRealPoint());
			commentRecordRepository.save(commentRecord);
		}
	
	return ;	
		 //topicRepository.save(topic);	
	}
	public void commit(Topic topic){
		SysUser sysUser=sysUserRepository.findByUsername(getUserDetails().getUsername());	
		//List<SysUser> sysUsers=topicRepository.findById(topic.getId()).get().getSysUsers();
		 Topic topic1=topicRepository.findById(topic.getId()).get();
		 List<SysUser> sysUsers = topic1.getSysUsers();
		 sysUsers.remove(sysUser);
		topic.setSysUsers(sysUsers);
		topicRepository.save(topic1);
		return ;	
	}
	
	public void deleteById(Long id){
		 topicRepository.deleteById(id);	
	}

}

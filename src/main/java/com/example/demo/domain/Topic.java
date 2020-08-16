package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.example.demo.sec.domain.SysUser;
@Entity
public class Topic {
	@Id
	@GeneratedValue
	public Long id;
	private String name;
	private String status;
	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
	private List<CommentTarget> commentTargets;
	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
	private List<SysUser> sysUsers;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<CommentTarget> getCommentTargets() {
		return commentTargets;
	}
	public void setCommentTargets(List<CommentTarget> commentTargets) {
		this.commentTargets = commentTargets;
	}
	public List<SysUser> getSysUsers() {
		return sysUsers;
	}
	public void setSysUsers(List<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
	public Topic(Long id, String name, String status , List<CommentTarget> commentTargets,
			List<SysUser> sysUsers) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.commentTargets = commentTargets;
		this.sysUsers = sysUsers;
	}
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

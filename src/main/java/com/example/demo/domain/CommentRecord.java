package com.example.demo.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.demo.sec.domain.SysUser;
@Entity
public class CommentRecord {
	@Id
	@GeneratedValue
	public Long id;
	@OneToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
	CommentTarget commentTarget;
	@OneToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
	SysUser sysUser;
	@OneToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
	Topic topic;
	private String rule;
	private BigDecimal point;
	private BigDecimal realPoint;
	private BigDecimal rankInGroup;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CommentTarget getCommentTarget() {
		return commentTarget;
	}
	public void setCommentTarget(CommentTarget commentTarget) {
		this.commentTarget = commentTarget;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public BigDecimal getPoint() {
		return point;
	}
	public void setPoint(BigDecimal point) {
		this.point = point;
	}
	public BigDecimal getRealPoint() {
		return realPoint;
	}
	public void setRealPoint(BigDecimal realPoint) {
		this.realPoint = realPoint;
	}
	
	public CommentRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BigDecimal getRankInGroup() {
		return rankInGroup;
	}
	public void setRankInGroup(BigDecimal rankInGroup) {
		this.rankInGroup = rankInGroup;
	}
	public CommentRecord(Long id, CommentTarget commentTarget, SysUser sysUser, Topic topic, String rule,
			BigDecimal point, BigDecimal realPoint, BigDecimal rankInGroup) {
		super();
		this.id = id;
		this.commentTarget = commentTarget;
		this.sysUser = sysUser;
		this.topic = topic;
		this.rule = rule;
		this.point = point;
		this.realPoint = realPoint;
		this.rankInGroup = rankInGroup;
	}
	
}

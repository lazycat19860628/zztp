package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Transient;

import com.example.demo.sec.domain.SysUser;

@Entity
public class CommentTarget {
	@Id
	@GeneratedValue
	public Long id;
	private String depart;
	private String name;
	private String employNo;
	private String sex;
	private String position;
	private String post;
	private String phoneNo;
	@Transient
	private BigDecimal point;
	@Transient
	private BigDecimal realPoint;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployNo() {
		return employNo;
	}
	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	public CommentTarget(Long id, String depart, String name, String employNo, String sex, String position, String post,
			String phoneNo) {
		super();
		this.id = id;
		this.depart = depart;
		this.name = name;
		this.employNo = employNo;
		this.sex = sex;
		this.position = position;
		this.post = post;
		this.phoneNo = phoneNo;

		
	}
	public CommentTarget() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

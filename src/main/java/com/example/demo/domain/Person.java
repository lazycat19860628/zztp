package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.example.demo.sec.domain.SysUser;

@Entity
public class Person {
	@Id
	@GeneratedValue
	public Long id;
	private String name;
	@OneToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
	private SysUser sysUser;
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
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public Person(Long id, String name, SysUser sysUser) {
		super();
		this.id = id;
		this.name = name;
		this.sysUser = sysUser;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

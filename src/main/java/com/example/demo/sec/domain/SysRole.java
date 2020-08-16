package com.example.demo.sec.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
//角色表
@Entity
@NamedQuery(name = "SysRole.withNameNamedQuery",
query = "select p from SysRole p where p.name=?1 ")
public class SysRole {


	@Id
	@GeneratedValue
	private Long id;
	private String name; //角色名
	private String checked;//是否已选，不持久化
	private Long pid;
	public SysRole() {
		super();
	}
	public SysRole(Long id, String name,String checked,Long pid) {
		super();
		this.id = id;
		this.name = name;
		this.checked = checked;
		this.pid = pid;
	}
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
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	

}

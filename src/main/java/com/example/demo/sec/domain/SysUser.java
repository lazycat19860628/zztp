package com.example.demo.sec.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.domain.CommentTarget;


@Entity
@NamedQuery(name = "SysUser.withUsernameAndPasswordNamedQuery",
query = "select p from SysUser p where p.username=?1 and password=?2")
public class SysUser implements UserDetails{ //1
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	public Long id;
	private String username;//用户名
	private String password;//密码
	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
	private List<SysRole> roles= new ArrayList<SysRole>(); //角色清单
	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.LAZY)
	private List<CommentTarget> commentTargets= new ArrayList<CommentTarget>(); //角色清单
	
	public List<CommentTarget> getCommentTargets() {
		return commentTargets;
	}

	public void setCommentTargets(List<CommentTarget> commentTargets) {
		this.commentTargets = commentTargets;
	}

	public SysUser() {
		super();
	}
	
	
	public SysUser(Long id, String username, String password, List<SysRole> roles, List<CommentTarget> commentTargets) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.commentTargets = commentTargets;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //2
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		List<SysRole> roles=this.getRoles();
		for(SysRole role:roles){
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		return auths;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	public void deleteRoles() {
	
		
	}

	
	
	
}

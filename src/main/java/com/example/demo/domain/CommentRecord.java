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
	private BigDecimal point;
	private BigDecimal realPoint;
	
}

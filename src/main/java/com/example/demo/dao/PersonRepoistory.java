package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Person;
import com.example.demo.sec.domain.SysUser;

public interface PersonRepoistory extends JpaRepository<Person, Long> {
	Person findBySysUser(SysUser sysUser);
}

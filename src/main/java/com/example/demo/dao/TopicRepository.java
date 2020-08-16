package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Topic;

public interface TopicRepository extends JpaRepository<Topic,Long>{
	@Query("SELECT topic FROM Topic topic JOIN topic.sysUsers user WHERE user.username=:name")
	List<Topic> findByUserName(@Param("name") String name);
	

}

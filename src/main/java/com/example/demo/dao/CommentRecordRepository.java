package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.CommentRecord;

public interface CommentRecordRepository extends JpaRepository<CommentRecord,Long>{
	List<CommentRecord> findByTopicIdAndSysUserId(@Param("topicId") Long topicId,@Param("sysUserId") Long sysUserId);
}

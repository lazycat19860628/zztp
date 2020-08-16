package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.CommentRecord;

public interface CommentRecordRepository extends JpaRepository<CommentRecord,Long>{

}

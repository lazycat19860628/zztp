package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.CommentTarget;

public interface CommentTargetRepository extends JpaRepository<CommentTarget,Long> {

}

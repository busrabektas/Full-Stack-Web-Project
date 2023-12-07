package com.project.questapp2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp2.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}

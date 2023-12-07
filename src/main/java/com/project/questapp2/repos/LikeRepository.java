package com.project.questapp2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp2.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}

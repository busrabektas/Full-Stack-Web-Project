package com.project.questapp2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.questapp2.entities.Post;
import com.project.questapp2.repos.PostRepository;

//This PostService class manages database operations through the PostRepository and generates appropriate responses to requests from the PostController class.

@Service
public class PostService {
	PostRepository postRepository;

	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent())
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(Post newPost) {
		return postRepository.save(newPost);
	}

}

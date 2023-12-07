package com.project.questapp2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp2.entities.Post;
import com.project.questapp2.services.PostService;



@RestController
@RequestMapping("/posts")
public class PostController {
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	
	@GetMapping //get all posts
	public List <Post> getAllPosts(@RequestParam Optional <Long> userId){ //requestin içindeki paramaetreleri parçalayıp alır
		return postService.getAllPosts(userId);
		
		
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody Post newPost) {
		return postService.createOnePost(newPost);
		
	}

	
	@GetMapping("/{postId}") //get one specific post
	public Post getOnePost(@PathVariable Long postId) {//slashtan sonraki değeri alıp değişkenin içerisine atar
		return postService.getOnePostById(postId);
	}
	

	
	
	

}

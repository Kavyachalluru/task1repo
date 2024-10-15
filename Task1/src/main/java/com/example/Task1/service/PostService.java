package com.example.Task1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task1.model.Post;
import com.example.Task1.repository.PostRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class PostService {
	@Autowired
	private PostRepository postRepo;
	public void add(Post post) {
		postRepo.save(post);
	}
	@CircuitBreaker(fallbackMethod = "viewFallback",name = "postService" )
	public List<Post> view() {
		return postRepo.findAll();
	}
	public Post getPostById(Long postId) {
		return postRepo.findById(postId).get();
	}
	 public List<Post> viewFallback(Throwable throwable) {
	        System.out.println("Fallback method triggered due to: " + throwable.getMessage());

	        // Return a default or empty list in case of failure
	        return new ArrayList<>();
}}

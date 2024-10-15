package com.example.Task1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Task1.model.Comment;
import com.example.Task1.model.Post;
import com.example.Task1.service.CommentService;
import com.example.Task1.service.PostService;

@Controller
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostService postSer;
	@Autowired
	private CommentService comSer;
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("post",new Post());
		return "PostForm";
	}
	@PostMapping("/posts")
	public String posts(@ModelAttribute Post post) {
		postSer.add(post);
		return "PostForm";
	}
	@GetMapping("/view")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postSer.view());
        return "View";
    }
	@GetMapping("/posts/{postId}/addc")
    public String showCommentForm(@PathVariable Long postId, Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("postId", postId);
        return "Comment"; 
    }
    @PostMapping("/posts/{postId}/comments")
    public String saveComment(@PathVariable Long postId, @ModelAttribute Comment comment) {
        Post post = postSer.getPostById(postId);
        comment.setPost(post);
        comSer.addc(comment);
        return "Comment";
    }
//    @GetMapping("/posts/{postId}")
//    public String getPost(@PathVariable Long postId, Model model) {
//        model.addAttribute("post", new Post());
//        model.addAttribute("postId", postId);
//        return "Post"; 
//    }

}

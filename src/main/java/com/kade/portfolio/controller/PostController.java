package com.kade.portfolio.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kade.portfolio.model.Post;
import com.kade.portfolio.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public List<Post> readAllPosts() {
		return service.readAll();
	}
	
	@PostMapping
	public Post createPost(@RequestBody Post post) {
		return service.create(post);
	}
	
	@GetMapping("/{id}")
	public Post readPost(@PathVariable Long id) {
		return service.read(id);
	}
	
	@PutMapping("/{id}")
	public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
		return service.update(id, post);
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable Long id) {
		service.delete(id);
	}
}
package com.kade.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.kade.portfolio.model.Post;
import com.kade.portfolio.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public List<Post> readAll() { return repo.findAll(); }
	public Post create(Post p) { return repo.save(p); }
	public Post read(Long id) { return repo.findById(id).get(); }
	public void delete(Long id) { repo.deleteById(id); }
	public Post update(Long id, Post newPost) {
		return repo.findById(id)
				.map(post -> {
					post.setTitle(newPost.getTitle());
					post.setContent(newPost.getContent());
					return repo.save(post);
				})
				.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
	}
}

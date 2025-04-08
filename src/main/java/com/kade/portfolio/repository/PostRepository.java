package com.kade.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kade.portfolio.model.Post;

// JPAがなんかやってくれる
// JPA does something in here
public interface PostRepository extends JpaRepository<Post, Long> {}
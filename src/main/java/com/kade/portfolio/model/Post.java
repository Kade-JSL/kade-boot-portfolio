package com.kade.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
// JPAエンティティ：ポスト(POSTリクエストじゃなくて記事)
// JPA entity: not POST request, articles for blogs or something
@Data
// めんどいコードはこれ一本で
// reduce boilerplate codes
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String title;
	private String content;
	// 必要によってメンバは追加していく
	// add members along demand
}

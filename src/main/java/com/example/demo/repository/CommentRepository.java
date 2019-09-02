package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domin.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
	
	public Comment findByFirstName(String firstName);
	public List<Comment> findByAge(int age);
	
	
}

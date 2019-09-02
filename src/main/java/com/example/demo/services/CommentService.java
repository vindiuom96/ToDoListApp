package com.example.demo.services;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domin.Comment;
import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	// create operation
	public Comment create(Comment comment) {
     comment.setId(UUID.randomUUID().toString());
		return commentRepository.save(comment);

	}

	// Retrieve operation
	public List<Comment> getAll() {
		return commentRepository.findAll();
	}

	public Comment getByFirstName(String firstName) {

		return commentRepository.findByFirstName(firstName);

	}

	// update operation
	public Comment update(String id, Comment comment) {
		Comment updated = commentRepository.findById(comment.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + comment.getId()));
		
		updated.setfirstName(comment.getfirstName());
		return commentRepository.save(updated);

	}

	// delete operations
	public void deleteAll() {

		commentRepository.deleteAll();

	}

	public void delete(String id) {
		
		
		Comment c = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		commentRepository.delete(c);
		

	}
}

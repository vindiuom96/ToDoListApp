package com.example.demo.controller;

import java.util.List;
//import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domin.Comment;
import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping
	public List<Comment> getAllComments() {

		return commentService.getAll();
	}

	@GetMapping(value = "/{firstName}")
	public Comment getUser(@PathVariable("firstName") String firstName) {
		Comment p = commentService.getByFirstName(firstName);

		return p;

	}

	@PostMapping
	public Comment create(@RequestBody Comment comment) {

		Comment p = commentService.create(comment);
		return p;

	}

	@PutMapping("/{commentId}")
	public ResponseEntity<Comment> updateUser(@PathVariable("commentId") String commentId,
			@Valid @RequestBody Comment comment) throws ResourceNotFoundException {

		Comment updatedComment = commentService.update(commentId, comment);

		return ResponseEntity.ok(updatedComment);

	}

	@DeleteMapping("/{commentId}")
	public ResponseEntity<Comment> deleteUser(@PathVariable("commentId") String id) {
		commentService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping

	public String deleteUser() {
		commentService.deleteAll();
		return "All comments were deleted";

	}
}

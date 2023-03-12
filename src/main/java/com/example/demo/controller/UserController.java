package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MovieEntity;
import com.example.demo.entity.ShowEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.MovieService;
import com.example.demo.service.ShowService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService service;

	@Autowired
	private MovieService m;

	@Autowired
	private ShowService s;

	@PostMapping("/adduser")
	public ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user) {

		return new ResponseEntity<UserEntity>(service.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public List<UserEntity> getAllUser() {
		return service.getAllUser();
	}

	@GetMapping("find/{userid}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("userid") int userid) {
		return new ResponseEntity<UserEntity>(service.getUserById(userid), HttpStatus.OK);
	}

	@PutMapping("update/{userid}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable("userid") long id, @Valid @RequestBody UserEntity user) {
		return new ResponseEntity<UserEntity>(service.updateUser(user,id), HttpStatus.OK);
	}

	@DeleteMapping("delete/{userid}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("userid") int userid) {
		service.deleteUser(userid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

	// --------------------User Side Operations on Movie module
	// ---------------------------//

	@GetMapping("/movie/list")
	public List<MovieEntity> getAllMovie() {
		return m.getAllMovie();
	}

	@GetMapping("movie/find/{movieid}")
	public ResponseEntity<MovieEntity> getMovieById(@PathVariable("movieid") int movieid) {
		return new ResponseEntity<MovieEntity>(m.getMovieById(movieid), HttpStatus.OK);
	}

	// --------------------User Side Operations on Show module
	// ---------------------------//

	@GetMapping("shows/list")
	public List<ShowEntity> getAllShow() {
		return s.getAllShow();
	}

	@GetMapping("/show/find/{showid}")
	public ResponseEntity<ShowEntity> getShowById(@PathVariable("showid") int showid) {
		return new ResponseEntity<ShowEntity>(s.getShowById(showid), HttpStatus.OK);
	}
}

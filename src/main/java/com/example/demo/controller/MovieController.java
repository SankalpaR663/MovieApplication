package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MovieEntity;
import com.example.demo.service.MovieService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/movie")
public class MovieController {
	@Autowired
	MovieService service;

	@PostMapping("/addmovie")
	public ResponseEntity<MovieEntity> addMovie(@Valid @RequestBody MovieEntity movie) {

		return new ResponseEntity<MovieEntity>(service.addMovie(movie), HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public List<MovieEntity> getAllMovie() {
		return service.getAllMovie();
	}

	@GetMapping("find/{id}")
	public ResponseEntity<MovieEntity> getMovieById(@PathVariable("id") long id) {
		return new ResponseEntity<MovieEntity>(service.getMovieById(id), HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<MovieEntity> updateMovie(@Valid @PathVariable("id") long id, @RequestBody MovieEntity movie) {
		return new ResponseEntity<MovieEntity>(service.updateMovie(movie,id), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Boolean> deleteMovie(@PathVariable("id") long id) {
		service.deleteMovie(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.MovieEntity;

public interface MovieService {
	
	public MovieEntity addMovie(MovieEntity movie);

	public List<MovieEntity> getAllMovie();

	public MovieEntity getMovieById(long id);

	public MovieEntity updateMovie(MovieEntity movie, long id);

	public void deleteMovie(long id);
}

package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MovieEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;



@Service
public class MovieServiceImpl implements MovieService 
{
	@Autowired
	MovieRepository dao;

	@Override
	public MovieEntity addMovie(MovieEntity movie) 
	{
		System.out.println("Movie added successfully" + movie);
		movie.setName(movie.getName());
		movie.setLanguage(movie.getLanguage());
		movie.setMovieType(movie.getMovieType());
		movie.setReleaseDate(movie.getReleaseDate());
		movie.setTheaterName(movie.getTheaterName());
		movie.setTheaterType(movie.getTheaterType());
		//movie.setShows(movie.getShows());
		return dao.save(movie);
	}

	@Override
	public List<MovieEntity> getAllMovie() 
	{
		return dao.findAll();
	}

	@Override
	public MovieEntity getMovieById(long id) 
	{
		return this.dao.findById(id).orElse(null);
	}

	public MovieEntity updateMovie(MovieEntity movie, long id) 
	{
		MovieEntity existingMovie = dao.findById(id).orElseThrow(()->new ResourceNotFoundException("Movie Id does not exist!!"));
		
		existingMovie.setName(movie.getName());
		existingMovie.setLanguage(movie.getLanguage());
		existingMovie.setMovieType(movie.getMovieType());
		existingMovie.setReleaseDate(movie.getReleaseDate());
		existingMovie.setTheaterName(movie.getTheaterName());
		existingMovie.setTheaterType(movie.getTheaterType());
		//existingMovie.setShows(movie.getShows());
		dao.save(existingMovie);
		
		return existingMovie;
	}

	@Override
	public void deleteMovie(long id) 
	{
		MovieEntity existsID = dao.findById(id).orElseThrow(()->new ResourceNotFoundException("Movie id does not exist!!"));
		dao.deleteById(id);
	}

}

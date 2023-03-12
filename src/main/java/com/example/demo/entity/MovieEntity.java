package com.example.demo.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.enums.MovieLanguage;
import com.example.demo.enums.MovieType;
import com.example.demo.enums.TheaterType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "language", nullable = false)
	private MovieLanguage language;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "movieType", nullable = false)
	private MovieType movieType;

	@Column(name = "release_date", columnDefinition = "DATE", nullable = false)
	private LocalDate releaseDate;
	
	@Column(name = "theaterName", nullable = false)
	private String theaterName;

	@Enumerated(EnumType.STRING)
	@Column(name = "theaterType", nullable = false)
	private TheaterType theaterType;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="movie_id",referencedColumnName = "id")
	private Set<ShowEntity> shows = new HashSet<>();
	
	public MovieEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieEntity(long id, String name, MovieLanguage language, MovieType movieType, LocalDate releaseDate,
			String theaterName, TheaterType theaterType, Set<ShowEntity> shows) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.movieType = movieType;
		this.releaseDate = releaseDate;
		this.theaterName = theaterName;
		this.theaterType = theaterType;
		this.shows = shows;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieLanguage getLanguage() {
		return language;
	}

	public void setLanguage(MovieLanguage language) {
		this.language = language;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public TheaterType getTheaterType() {
		return theaterType;
	}

	public void setTheaterType(TheaterType theaterType) {
		this.theaterType = theaterType;
	}

	public Set<ShowEntity> getShows() {
		return shows;
	}

	public void setShows(Set<ShowEntity> shows) {
		this.shows = shows;
	}

}

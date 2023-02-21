package com.example.moviedetailapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviedetailapplication.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{
	List<Movie> findByTitleAndYearAndRuntime (String title, String year, String runtime);
}

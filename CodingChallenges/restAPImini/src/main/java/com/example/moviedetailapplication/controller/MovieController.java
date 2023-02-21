package com.example.moviedetailapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.moviedetailapplication.model.Movie;
import com.example.moviedetailapplication.repository.MovieRepository;
import com.example.moviedetailapplication.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	MovieService movieServ;
	
	@GetMapping("/")
	public String goToMovieSearch() {
		return "redirect:/movieSearch";
	}
	
	@GetMapping("/movieSearch")
	public String searchMovie(Model model) {
		model.addAttribute("movietitle", new Movie());
		model.addAttribute("movie", new Movie());
		return "movieSearch";
	}
	
	@PostMapping("/movieSearch")
	public String getMovieDetails(Model model, Movie movietitle) {

		Movie movie = movieServ.getMovieFromAPI(movietitle.getTitle());
		if (movie.getTitle() == null) {
			model.addAttribute("movietitle", new Movie());
			movie.setTitle("MOVIE NOT FOUND");
			model.addAttribute("movie", movie);
		}
		
		List<Movie> existingMovie = movieRepo.findByTitleAndYearAndRuntime(movie.getTitle(), movie.getYear(), movie.getRuntime());
		System.out.println(existingMovie);
		
		if (existingMovie.isEmpty()) {
			movieRepo.save(movie);
		}
		
		model.addAttribute("movietitle", new Movie());
		model.addAttribute("movie", movie);
		return "movieSearch";
	}

	@GetMapping("/movieArchive")
	public String displayMovieHistory(Model model) {
		
		model.addAttribute("movieList", movieRepo.findAll());
		return "movieArchive";

	}
	
}

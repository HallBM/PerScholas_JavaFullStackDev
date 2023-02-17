package com.example.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MovieController {
	
	@GetMapping("/movieSearch")
	public String searchMovie(Model model) {
		model.addAttribute("movietitle", new Movie());
		model.addAttribute("movie", new Movie());
		return "movieSearch";
	}
	
	@PostMapping("/movieSearch")
	public String getMovieDetails(Model model, Movie movietitle) {

		Movie movie = new Movie();
		
		System.out.println(movietitle.getTitle());
		try {
			String apiKey = "b79fdda2";
			String urlString = String.format("https://www.omdbapi.com/?apikey=%s&t=%s", apiKey, movietitle.getTitle());

			// Open a connection to the API URL and retrieve the data as a string
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();
			String response = "";
			if (responseCode == HttpURLConnection.HTTP_OK) {
				Scanner scanner = new Scanner(conn.getInputStream());
				while (scanner.hasNext()) {
					response += scanner.nextLine();
					System.out.println(response);
				}
				scanner.close();
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String,String> movieMap = objectMapper.readValue(response, Map.class);
			System.out.println(movieMap);
			
			movie.setTitle(movieMap.get("Title"));
			movie.setYear(movieMap.get("Year"));
			movie.setRated(movieMap.get("Rated"));
			movie.setReleased(movieMap.get("Released"));
			movie.setRuntime(movieMap.get("Runtime"));
			movie.setGenre(movieMap.get("Genre"));
			movie.setDirector(movieMap.get("Director"));
			movie.setWriter(movieMap.get("Writer"));
			movie.setActors(movieMap.get("Actors"));
			movie.setPlot(movieMap.get("Plot"));
			movie.setLanguage(movieMap.get("Language"));
			movie.setCountry(movieMap.get("Country"));
			movie.setAwards(movieMap.get("Awards"));
			movie.setPoster(movieMap.get("Poster"));
			
			Pattern pattern = Pattern.compile("Rotten Tomato.*?(\\d+%)");
			Matcher matcher = pattern.matcher(response);
			
			String score = "Not found";
			if (matcher.find()) {
			    score = matcher.group(1);
			} 
			
			movie.setRating(score);
			System.out.println(movie.getPoster());

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("movietitle", new Movie());
		model.addAttribute("movie", movie);

		return "movieSearch";
	}

}

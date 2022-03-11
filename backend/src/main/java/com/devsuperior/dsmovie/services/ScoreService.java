package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

public class ScoreService {

	@Autowired
	private MovieRepository movierepository;
	
	private UserRepository userrepository;

	private ScoreRepository scorerepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userrepository.findByEmail(dto.getEmail());
	
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userrepository.saveAndFlush(user);
		}
		 Movie movie = movierepository.findById(dto.getMovieId()).get();
		 
		 Score score = new Score();
		 score.setMovie(movie);
		 score.setUser(user);
		 score.setValue(dto.getScore());
		 
		 score = scorerepository.saveAndFlush(score);
		 
		 double sum = 0.0;
		 for (Score s: movie.getScores()) {
			 sum = sum + s.getValue();		 
		 }
		  double avg = sum / movie.getScores().size();
		  
		  movie.setScore(avg);
		  movie.setCount(movie.getScores().size());
		  
		  movie = movierepository.saveAndFlush(movie);
		  
			return new MovieDTO(movie);
	}

}

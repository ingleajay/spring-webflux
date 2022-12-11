package com.reactor.movieinfoservice.services;

import org.springframework.stereotype.Service;

import com.reactor.movieinfoservice.model.MovieInfo;
import com.reactor.movieinfoservice.repository.MovieInfoRepository;

import reactor.core.publisher.Mono;

@Service
public class MoviesInfoService {

	private MovieInfoRepository movieInfoRepository;

    public MoviesInfoService(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository = movieInfoRepository;
    }
    
    public Mono<MovieInfo> addMovieInfo(MovieInfo movieInfo) {
        return movieInfoRepository.save(movieInfo)
                .log();
    }
	
}

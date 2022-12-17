package com.reactor.movieinfoservice.services;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reactor.movieinfoservice.model.MovieInfo;
import com.reactor.movieinfoservice.repository.MovieInfoRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
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
    
    public Flux<MovieInfo> getAllMovieInfos(){

        return  movieInfoRepository.findAll();
    }
	
    public Mono<MovieInfo> getMovieInfoById(String id) {
        return movieInfoRepository.findById(id);
    }
    public Flux<MovieInfo> getMovieInfoByYear(Integer year){

        return movieInfoRepository.findByYear(year);
    }
    
    public Mono<MovieInfo> updateMovieInfo(MovieInfo movieInfo, String id) {
        return movieInfoRepository.findById(id)
                .flatMap(movieInfo1 -> {
                    movieInfo1.setCast(movieInfo.getCast());
                    movieInfo1.setName(movieInfo.getName());
                    movieInfo1.setRelease_date(movieInfo.getRelease_date());
                    movieInfo1.setYear(movieInfo.getYear());
                    return movieInfoRepository.save(movieInfo1);
                });
    }

    public Mono<Void> deleteMovieInfoById(String id) {
        return movieInfoRepository.deleteById(id);
    }
}

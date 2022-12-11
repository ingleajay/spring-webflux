package com.reactor.movieinfoservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactor.movieinfoservice.model.MovieInfo;

public interface MovieInfoRepository extends ReactiveMongoRepository<MovieInfo,String> {

}

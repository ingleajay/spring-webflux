package com.reactor.moviesreviewservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactor.moviesreviewservice.model.Review;

import reactor.core.publisher.Flux;

public interface ReviewReactiveRepository extends ReactiveMongoRepository<Review, String> {

    //Flux<Review> findReviewsByMovieInfoId(String reviewId);

    Flux<Review> findReviewsByMovieInfoId(Long movieInfoId);
}

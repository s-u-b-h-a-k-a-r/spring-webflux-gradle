package com.example.service;

import com.example.model.Movie;
import com.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Mono<Movie> byId(String id) {
        return movieRepository.findById(id);
    }

    public Flux<Movie> all() {
        return movieRepository.findAll();
    }
}

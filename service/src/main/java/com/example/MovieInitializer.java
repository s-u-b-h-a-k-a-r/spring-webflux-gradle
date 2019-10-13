package com.example;

import com.example.model.Movie;
import com.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


@Component
public class MovieInitializer {
    @Autowired
    private MovieRepository movieRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void run(ApplicationReadyEvent evt) {
        this.movieRepository
                .deleteAll()
                .thenMany(
                        Flux
                                .just("Foo", "Bar")
                                .flatMap(title -> this.movieRepository.save(new Movie(title))))
                .subscribe(null, null, () -> this.movieRepository.findAll().subscribe(System.out::println)
                );

    }
}

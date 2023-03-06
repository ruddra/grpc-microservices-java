package com.grpcflix.aggregator.controller;

import com.grpcflix.aggregator.dto.RecommendedMovie;
import com.grpcflix.aggregator.dto.UserGenre;
import com.grpcflix.aggregator.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLException;
import java.util.List;

@RestController
public class AggregatorController {

    @Autowired
    private UserMovieService userMovieService;

    @GetMapping("/user/{loginId}")
    public List<RecommendedMovie> getMovies(@PathVariable String loginId) throws SSLException {
        return this.userMovieService.getUserMovieSuggestions(loginId);
    }

    @PutMapping("/users")
    public ResponseEntity<Object> setUserGenre(@RequestBody UserGenre userGenre) throws SSLException {
        this.userMovieService.setUserGenreObject(userGenre);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
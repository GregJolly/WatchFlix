package com.watchflix.app.controller;

import com.watchflix.app.domain.dto.response.MovieDetailDto;
import com.watchflix.app.domain.dto.response.MovieSummaryDto;
import com.watchflix.app.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping(path = "/popular")
    public ResponseEntity<List<MovieSummaryDto>> getPopularMovies() {



        return new ResponseEntity<>(movieService.getPopularMovies(), HttpStatus.OK);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<MovieSummaryDto>> searchMovie(@RequestParam String q)
    {
        return new ResponseEntity<>(movieService.searchMovies(q), HttpStatus.OK);
    }

    @GetMapping(path = "/{tmdbId}")
    public ResponseEntity<MovieDetailDto> getMovieById(@PathVariable Integer tmdbId)
    {
        return new ResponseEntity<>(movieService.getMoviebyId(tmdbId), HttpStatus.OK);
    }

}

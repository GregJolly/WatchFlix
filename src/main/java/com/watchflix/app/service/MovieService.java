package com.watchflix.app.service;

import com.watchflix.app.domain.dto.response.MovieDetailDto;
import com.watchflix.app.domain.dto.response.MovieSummaryDto;
import com.watchflix.app.domain.entity.UserMovie;
import com.watchflix.app.domain.tmdb.TmdbMovieResponse;

import java.util.List;

    public interface MovieService {
        List<MovieSummaryDto> getPopularMovies();
        List<MovieSummaryDto> searchMovies(String query);
        MovieDetailDto getMoviebyId(Integer id);

    }

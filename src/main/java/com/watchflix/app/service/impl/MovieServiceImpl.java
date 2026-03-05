package com.watchflix.app.service.impl;

import com.watchflix.app.domain.dto.response.MovieDetailDto;
import com.watchflix.app.domain.dto.response.MovieSummaryDto;
import com.watchflix.app.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    @Override
    public List<MovieSummaryDto> getPopularMovies() {
        return List.of();
    }

    @Override
    public List<MovieSummaryDto> searchMovies(String query) {
        return List.of();
    }

    @Override
    public MovieDetailDto getMoviebyId(Integer id) {
        return null;
    }
}

package com.example.MovieBackend.facades;

import com.example.MovieBackend.dtos.Movie;
import com.example.MovieBackend.dtos.MoviePage;
import com.example.MovieBackend.services.MovieDBservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieFacade {


    private final MovieDBservice movieDBService;



    public MoviePage getPopularMovies(Integer page) {

        return movieDBService.getPopularMovies(page);
        }

    public Movie getMovieDetail(Integer movieID) {
        return movieDBService.getMovieDetails(movieID);
    }

    public MoviePage search(String input,int page) {

        return (movieDBService.search(input,page));
    }
}


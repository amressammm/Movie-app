package com.example.MovieBackend.services;

import com.example.MovieBackend.dtos.Movie;
import com.example.MovieBackend.dtos.MoviePage;
import com.example.MovieBackend.repository.MoviePageRepository;
import com.example.MovieBackend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieDBservice {

    private final RestTemplate restTemplate;

    private String apiKey = "a97243d7813d31446f6c43284e6854d5";

    private String apiUrl = "https://api.themoviedb.org/3";

    private static final String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";


    @Autowired
    private MoviePageRepository moviePageRepository;
    @Autowired
    private MovieRepository movieRepository;

    public MoviePage getPopularMovies(Integer page) {


		if(moviePageRepository.findById(page).isEmpty()) {

            String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey + "&page="
                    + page.intValue();

            MoviePage result= restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody();
            List<Movie> temp=result.getResults();
            for(int i=0;i<temp.size();i++){
                if(!movieRepository.findById(temp.get(i).getId()).isEmpty())
                    result.getResults().get(i).setId(temp.get(i).getId()+4);
                     movieRepository.save(temp.get(i));
            }
            moviePageRepository.save(result);
                return (result);
        }else{
            return(moviePageRepository.findById(page).get());
        }
    }


    public Movie getMovieDetails(Integer movieID) {

        Movie result = movieRepository.findById(movieID).get();

        String urlForPopularMovies = apiUrl + "/movie/" + movieID + "?api_key=" + apiKey;

        result = restTemplate.getForEntity(urlForPopularMovies, Movie.class).getBody();

        movieRepository.save(result);
        return result;


    }

    public MoviePage search(String input,int page) {

        String urlForPopularMovies = apiUrl + "/search/movie" + "?&api_key=" + apiKey+"&query=" + input+"&page="+page;

        MoviePage result= restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody();

        return result;

    }}

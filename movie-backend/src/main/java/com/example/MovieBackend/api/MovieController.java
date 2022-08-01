package com.example.MovieBackend.api;

import com.example.MovieBackend.dtos.Movie;
import com.example.MovieBackend.dtos.MoviePage;
import com.example.MovieBackend.facades.MovieFacade;
import com.example.MovieBackend.repository.MoviePageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MoviePageRepository moviePageRepository;
    private final MovieFacade movieFacade;


    @GetMapping(path="/popular")
    public ResponseEntity<Object> popular(@RequestParam Integer page){

        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Object> response=new ResponseEntity<>(movieFacade.getPopularMovies(page),HttpStatus.OK);
        return(response);


    }

    @GetMapping(path="/movie")
    public ResponseEntity<Object> getMovie(@RequestParam  Integer movieID){

        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Object> response=(new ResponseEntity<>(movieFacade.getMovieDetail(movieID), HttpStatus.OK));

        return(response);
    }


    @GetMapping(path="/search")
    public ResponseEntity<Object>  search(@RequestParam  String input,int page){
        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Object> response=(new ResponseEntity<>(movieFacade.search(input,page), HttpStatus.OK));
        return(response);
    }

    @GetMapping(path = "/test")
    public Iterable<MoviePage> test1(){
        return (moviePageRepository.findAll());
    }

}

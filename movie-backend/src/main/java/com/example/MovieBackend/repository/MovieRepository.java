package com.example.MovieBackend.repository;

import com.example.MovieBackend.dtos.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,Integer> {
}

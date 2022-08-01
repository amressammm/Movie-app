package com.example.MovieBackend.repository;

import com.example.MovieBackend.dtos.MoviePage;
import org.springframework.data.repository.CrudRepository;

public interface MoviePageRepository extends CrudRepository<MoviePage,Integer> {
}

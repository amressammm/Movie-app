package com.example.MovieBackend.dtos;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    @Id
    private int id;
    private boolean adult;
    ArrayList<Integer> genre_ids;


    private String backdrop_path;
    private String original_language;
    private String original_title;
    @Column(length = 1000)
    private String overview;
    private String popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private float vote_average;
    private int vote_count;
    @ManyToOne( fetch = FetchType.LAZY)
    private MoviePage moviePage;



}

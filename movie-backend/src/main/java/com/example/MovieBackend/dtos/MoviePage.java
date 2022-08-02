package com.example.MovieBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class MoviePage {
    @Id
    private int page;

      @ElementCollection(fetch = FetchType.EAGER)
      @Column(name = "results")
      @CollectionTable(name = "entity_attributes", joinColumns = @JoinColumn(name = "entity_id"))
      private List<Movie> results = new ArrayList<>();



}

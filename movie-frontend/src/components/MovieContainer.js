import React, { useState, useEffect } from "react";
import CssBaseline from "@mui/material/CssBaseline";
import Box from "@mui/material/Box";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import Pagination from "@mui/material/Pagination";
import MovieCard from "./MovieCard";
import axios from "axios";
import classes from "../styles/moviesContainer.module.css";
import LoadingIcons from "react-loading-icons";

const MovieContainer = (props) => {
  const [Movies, setMovies] = useState([]);
  const [Loading, setLoading] = useState(true);

  useEffect(() => {
    if (props.search === false) getMovies(1);
    else {
      getSearch(1);
    }
    loading();
  }, [props.input]);

  const getMovies = async (input) => {
    let res = await axios.get(
      `http://localhost:8080/api/v1/movies/popular?page=${input}`
    );

    setMovies(res.data.results);
  };

  const getSearch = async (input) => {
    if (props.input !== "") {
      let res = await axios.get(
        `http://localhost:8080/api/v1/movies/search?input=${props.input}&page=${input}`
      );
      setMovies(res.data.results);
    }
  };

  const loading = async () => {
    await delay(1020);
    setLoading(false);
  };
  const delay = (ms) => new Promise((resolve) => setTimeout(resolve, ms));

  const handlePageChange = async (event, value) => {
    if (props.search === false) getMovies(value);
    else {
      getSearch(value);
    }
  };

  return Loading ? (
    <LoadingIcons.Circles className={classes.loading} />
  ) : (
    <React.Fragment>
      <CssBaseline />
      {Movies.length !== 0 ? (
        <Container maxWidth="lg">
          <Box sx={{ height: "100vh" }}>
            <Box sx={{ width: "100%" }}>
              <Grid container rowSpacing={2} columnSpacing={3}>
                {Movies.map((e) => {
                  return (
                    <Grid item xs={3}>
                      <MovieCard
                        title={e.title}
                        date={e.release_date}
                        img={e.poster_path}
                        popularity={e.popularity}
                        overview={e.overview}
                      />
                    </Grid>
                  );
                })}
              </Grid>
            </Box>

            <Pagination
              size="large"
              count={10}
              className={classes.pagination}
              onChange={handlePageChange}
            />
          </Box>
        </Container>
      ) : (
        <h1 className={classes.notFound}>No results found!!</h1>
      )}
    </React.Fragment>
  );
};

export default MovieContainer;

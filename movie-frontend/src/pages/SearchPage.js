import React, { useState, useEffect } from "react";
import MovieContainer from "../components/MovieContainer";
import NavBar from "../components/NavBar";
import { useLocation } from "react-router-dom";
import classes from "../styles/searchPage.module.css";

const SearchPage = () => {
  const [Movies, setMovies] = useState([]);
  const [Search, setSearch] = useState("");
  const { state } = useLocation();

  useEffect(() => {
    setSearch(state.search);
  }, []);

  const searchChangeHandler = (input) => {
    setSearch(input);
  };

  return (
    <div className={classes.container}>
      <NavBar searchChangeHandler={searchChangeHandler} searchPage={true} />
      <br />
      <MovieContainer movies={Movies} search={true} input={Search} />
    </div>
  );
};

export default SearchPage;

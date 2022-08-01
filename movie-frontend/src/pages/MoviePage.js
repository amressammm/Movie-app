import React from "react";
import classes from "../styles/moviePage.module.css";
import { useLocation } from "react-router-dom";
import NavBar from "../components/NavBar";

const MoviePage = (props) => {
  const { state } = useLocation();
  return (
    <div>
      <NavBar />
      <div className={classes.container}>
        <div className={classes.img}>
          <img src={state.img}></img>
        </div>

        <div className={classes.disc}>
          <h1 className={classes.title}>{state.title} </h1>
          <p className={classes.info}>
            <b>Overview: </b>
            {state.overview}
          </p>
          <br />
          <p className={classes.info}>
            <b>Release date: </b> {state.release_date}
          </p>
          <p className={classes.info}>
            <b>Popularity: </b> {state.popularity}
          </p>
        </div>
      </div>
    </div>
  );
};

export default MoviePage;

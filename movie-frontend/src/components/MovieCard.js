import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActionArea, CardActions } from "@mui/material";
import classes from "../styles/movieCard.module.css";
import { useNavigate } from "react-router-dom";

const MovieCard = (props) => {
  const navigate = useNavigate();

  return (
    <Card className={classes.card}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="290"
          image={
            props.img !== null
              ? `https://image.tmdb.org/t/p/w500/${props.img}`
              : "https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-scaled-1150x647.png"
          }
          alt="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {props.title}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {props.date}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button
          size="small"
          color="primary"
          onClick={() =>
            navigate("/moviePage", {
              state: {
                img: `https://image.tmdb.org/t/p/w500/${props.img}`,
                title: props.title,
                overview: props.overview,
                release_date: props.date,
                popularity: props.popularity,
              },
            })
          }
        >
          View
        </Button>
      </CardActions>
    </Card>
  );
};

export default MovieCard;

import "./App.css";
import api from "./api/axiosConfig";
import Layout from "./Components/Layout";
import { Routes, Route } from "react-router-dom";
import { useState, useEffect } from "react";
import Home from "./Components/home/Home";
import Header from "./Components/header/Header";
import Trailer from "./Components/trailer/Trailer";
import Reviews from "./Components/reviews/Reviews";

function App() {
  const [movies, setMovies] = useState();
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState();

  const getMovies = async () => {
    try {
      const response = await api.get("/getAll");
      setMovies(response.data);
    } catch (error) {
      console.log(error.printStackTrace());
    }
  };

  const getMovie = async (movieID) => {
    try {
      console.log("getMovie: " + movieID);
      const response = await api.get(`/getMovie/${movieID}`);
      const singleMovie = response.data;
      console.log({ singleMovie });
      setMovie(singleMovie);
      setReviews(singleMovie.reviews);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getMovies();
  }, []);

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />} />
          <Route path="/trailer/:yID" element={<Trailer />} />
          <Route
            path="/reviews/:movieID"
            element={
              <Reviews
                getMovieData={getMovie}
                movie={movie}
                reviews={reviews}
                setReviews={setReviews}
              />
            }
          />
        </Route>
      </Routes>
    </div>
  );
}

export default App;

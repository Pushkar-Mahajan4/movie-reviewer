import "./App.css";
import api from "./api/axiosConfig";
import Layout from "./Components/Layout";
import { Routes, Route } from "react-router-dom";
import { useState, useEffect } from "react";
import Home from "./Components/home/Home";

function App() {
  const [movies, setMovies] = useState();

  const getMovies = async () => {
    try {
      const response = await api.get("/getAll");
      setMovies(response.data);
    } catch (error) {
      console.log(error.printStackTrace());
    }
  };

  useEffect(() => {
    getMovies();
  }, []);

  return (
    <div className="App">
      {console.log(movies)}
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;

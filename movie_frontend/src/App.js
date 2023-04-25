import "./App.css";
import { useState, useEffect } from "react";

function App() {
  const [movieData, setMovieData] = useState("");
  useEffect(() => {
    fetch("http://127.0.0.1:8080/api/v1/movies/getMovie/tt3915174")
      .then((response) => response.json())
      .then((data) => setMovieData(data));
  }, []);
  return (
    <div className="App">
      <p>{console.log(movieData)}</p>
    </div>
  );
}

export default App;

package com.pushkar.movies.Repository;


import com.pushkar.movies.Model.Movie;
import com.pushkar.movies.Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies(){ return movieRepository.findAll(); }

    public Movie getMovieByimdbId(String imdbId){
        Optional<Movie> search = movieRepository.findMovieByImdbId(imdbId);
        Movie result = search.orElse(null);
        return result;
    }

    public Movie updateMovieByimdbId(Movie update){
        System.out.println(update);
        movieRepository.save(update);
        return update;
    }
}

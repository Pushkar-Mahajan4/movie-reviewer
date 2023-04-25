package com.pushkar.movies.Repository;


import com.pushkar.movies.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieByimdbId(String imdbId){

        List<Movie> movies = movieRepository.findAll();
        for(Movie movie : movies){
            if(movie.getImdbId().equals(imdbId)){
                return movie;
            }
        }
        return null;
    }
}

package com.pushkar.movies.Controller;

import com.pushkar.movies.Model.Movie;
import com.pushkar.movies.Repository.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/v1/movies")
public class Rest_Controller {

    @Autowired
    private MovieService movieService;

    @GetMapping("/getAll")
    private ResponseEntity<List<Movie>> getAllMovies(){
            return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
        }

    @GetMapping("/getMovie/{id}")
    private ResponseEntity<Movie> getMovieByID(@PathVariable String id){
        return new ResponseEntity<Movie>(movieService.getMovieByimdbId(id), HttpStatus.OK);
    }


}

package com.pushkar.movies.Controller;

import com.pushkar.movies.DAO.MovieDAO;
import com.pushkar.movies.Repository.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/movies")
public class Rest_Controller {

    @Autowired
    private MovieService movieService;

    @GetMapping("/getAll")
    private ResponseEntity<List<MovieDAO>> getAllMovies(){
            return new ResponseEntity<List<MovieDAO>>(movieService.getAllMovies(), HttpStatus.OK);
        }

}

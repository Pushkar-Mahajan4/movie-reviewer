package com.pushkar.movies.Repository;

import com.pushkar.movies.Model.Movie;
import com.pushkar.movies.Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Review> getReviews(String imbdId){
        return reviewRepository.findAll();
    }

    public Review addReview(Review review){

        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
        review.setDate(timeStamp);
        Review addReview = reviewRepository.insert(review);
        try{
            mongoTemplate.update(Movie.class)
                    .matching(Criteria.where("imdbId").is(review.getImdbId()))
                    .apply(new Update().push("reviewList").value(review))
                    .first();

        }catch (Exception e){
            e.printStackTrace();
        }
        return review;
    }


}

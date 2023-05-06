import { useEffect, useRef } from "react";
import api from "../../api/axiosConfig";
import { useParams } from "react-router-dom";
import { Container, Row, Col } from "react-bootstrap";
import ReviewForm from "../review-form/ReviewForm";

import React from "react";

const Reviews = ({ getMovieData, movie, reviews, setReviews }) => {
  const revText = useRef();
  let params = useParams();
  const movieID = params.movieID;

  const addReview = async (e) => {
    e.preventDefault();
    try {
      const rev = revText.current;
      await api.post("/addReview", {
        body: rev.value,
        id: movieID,
      });

      const updatedReviews = [...reviews, { body: rev.value }];
      rev.value = "";

      setReviews(updatedReviews);
    } catch (e) {
      console.log(e);
    }
  };

  useEffect(() => {
    getMovieData(movieID);
  }, []);
  return (
    <Container>
      <Row>
        <Col>
          <h3>Reviews</h3>
        </Col>
      </Row>
      <Row className="mt-2">
        <Col>
          <img src={movie?.poster} alt="Movie-Poster" />
        </Col>
        <Col>
          {
            <>
              <Row>
                <Col>
                  <ReviewForm
                    handleSubmit={addReview}
                    revText={revText}
                    labelText="Write a review:"
                  />
                </Col>
              </Row>
              <Row>
                <Col>
                  <hr />
                </Col>
              </Row>
            </>
          }
          {reviews?.map((element) => {
            return (
              <>
                <Row>
                  <Col>{element.body}</Col>
                </Row>
                <Row>
                  <Col>
                    <hr />
                  </Col>
                </Row>
              </>
            );
          })}
        </Col>
        <Row>
          <Col>
            <hr />
          </Col>
        </Row>
      </Row>
    </Container>
  );
};

export default Reviews;

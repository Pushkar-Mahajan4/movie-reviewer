package com.pushkar.movies.DAO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviewList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDAO {
    @Id
    private ObjectId id;

    private String body;
}

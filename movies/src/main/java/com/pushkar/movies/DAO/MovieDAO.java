package com.pushkar.movies.DAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "moviesList")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDAO {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerlink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;

    @DocumentReference
    private List<ReviewDAO> reviewIDs;

}

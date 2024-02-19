package dev.rbeccahsu.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "books") // represents each document in the book collection
@Data // Takes care of getters, setters and to_string methods
@AllArgsConstructor // Creates constructor that takes the private fields as arguments
@NoArgsConstructor // Creates constructor that takes no parameters as argument
public class Book {
    @Id
    private ObjectId id;
    private String isbn;
    private String title;
    private String author;
    private String published;
    private List<String> genres;
    private int pages;
    private String description;
    private String imageLink;
    @DocumentReference // database store only IDs of review and reviews will be in a separate collection
    private List<Review> reviewIds;
}

package dev.rbeccahsu.books;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// API/Controller Layer: gets a request from the user and returning a response
// Uses a service class and delegating the task of fetching all movies from database and giving
// back to the API layer
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping // Get method
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<List<Book>>(bookService.allBooks(), HttpStatus.OK);
    }

    @GetMapping("/{isbn}") // Searches a movie by ID
    public ResponseEntity<Optional<Book>> getSingleBook(@PathVariable String isbn) {
    return new ResponseEntity<Optional<Book>>(bookService.singleBook(isbn), HttpStatus.OK);
    }
}

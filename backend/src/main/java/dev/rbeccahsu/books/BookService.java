package dev.rbeccahsu.books;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service Layer
// Uses the repository class and get the list of books from database and returns to API layer
@Service
public class BookService {
    @Autowired // Instantiates BookRepository class
    private BookRepository bookRepository;
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> singleBook(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }
}

package dev.rbeccahsu.books;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Data Access Layer: job of communicating with the database and getting data
@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {
    Optional<Book> findBookByIsbn(String isbn);
}

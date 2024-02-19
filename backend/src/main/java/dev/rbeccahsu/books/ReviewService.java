package dev.rbeccahsu.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    // Look for book with given isbn, then create a new review and associate the review with that book
    public Review createReview(String reviewBody, String isbn) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        // Using template to perform an update call on the Book class
        // Updates the reviewIds array and pushes new review into database
        mongoTemplate.update(Book.class)
                .matching(Criteria.where("isbn").is(isbn))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}

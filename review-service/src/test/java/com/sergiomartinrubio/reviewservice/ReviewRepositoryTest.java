package com.sergiomartinrubio.reviewservice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

@DataMongoTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void repositoryShouldSaveAndReturnSameReview() {
        StepVerifier.create(
                reviewRepository.save(new Review("1", "Sergio", "text"))
                        .thenMany(reviewRepository.findAll())
        )
                .expectNextMatches(review -> review.getName().equals("Sergio"))
                .verifyComplete();
    }
}

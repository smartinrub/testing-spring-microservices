package com.sergiomartinrubio.reviewservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@DataMongoTest
@RunWith(SpringRunner.class)
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

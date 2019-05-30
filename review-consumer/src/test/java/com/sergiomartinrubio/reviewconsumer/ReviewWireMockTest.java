package com.sergiomartinrubio.reviewconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = "com.sergiomartinrubio:review-service:+:8080",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@Import({ReviewConsumerApplication.class, ReviewClient.class})
public class ReviewWireMockTest {

    @Autowired
    private ReviewClient reviewClient;

    @Test
    public void clientShouldReturnReview() {
        StepVerifier.create(reviewClient.getAllReviews())
                .expectNextMatches(review -> review.getName().equals("Sergio") && review.getText().equals("text"))
                .verifyComplete();
    }
}

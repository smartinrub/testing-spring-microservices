package com.sergiomartinrubio.reviewconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.util.Collections.singletonList;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static wiremock.org.apache.http.HttpHeaders.CONTENT_TYPE;

@ExtendWith(SpringExtension.class)
@AutoConfigureWireMock
@AutoConfigureJsonTesters
@Import({ReviewConsumerApplication.class, ReviewClient.class})
public class ReviewWireMockTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReviewClient reviewClient;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(singletonList(new Review("1", "Sergio", "text")));

        stubFor(get("/reviews")
                .willReturn(aResponse()
                        .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                        .withBody(json)));

    }

    @Test
    public void clientShouldReturnReview() {
        StepVerifier.create(reviewClient.getAllReviews())
                .expectNextMatches(review -> review.getAuthor().equals("Sergio") && review.getText().equals("text"))
                .verifyComplete();
    }
}

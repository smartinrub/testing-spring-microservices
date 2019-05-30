package com.sergiomartinrubio.reviewservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest
@RunWith(SpringRunner.class)
@Import(ProducerRestConfiguration.class)
public class ReviewControllerTest {

    @MockBean
    private ReviewRepository reviewRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getReviewsShouldReturnFluxOfReviews() {
        when(reviewRepository.findAll()).thenReturn(Flux.just(new Review("1", "Sergio", "text")));

        webTestClient
                .get()
                .uri("/reviews")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("@.[0].name").isEqualTo("Sergio");
    }
}

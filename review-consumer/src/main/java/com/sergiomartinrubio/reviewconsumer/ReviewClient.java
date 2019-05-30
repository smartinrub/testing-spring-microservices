package com.sergiomartinrubio.reviewconsumer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ReviewClient {

    private final WebClient webClient;

    Flux<Review> getAllReviews() {
        return webClient
                .get()
                .uri("http://localhost:8080/reviews")
                .retrieve()
                .bodyToFlux(Review.class);
    }
}

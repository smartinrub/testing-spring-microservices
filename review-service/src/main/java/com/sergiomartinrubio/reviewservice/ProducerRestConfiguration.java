package com.sergiomartinrubio.reviewservice;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class ProducerRestConfiguration {

    private final ReviewRepository reviewRepository;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route(RequestPredicates.GET("/reviews"), serverRequest -> ok().body(reviewRepository.findAll(), Review.class));
    }
}

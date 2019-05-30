package com.sergiomartinrubio.reviewservice;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface ReviewRepository extends ReactiveCrudRepository<Review, String> {
}

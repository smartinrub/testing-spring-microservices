package com.sergiomartinrubio.reviewservice;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "server.port=0")
@RunWith(SpringRunner.class) // JUnit 5 is not compatible
@Import(ProducerRestConfiguration.class)
public class BaseClass {

    @LocalServerPort
    private int port;

    @MockBean
    private ReviewRepository reviewRepository;

    @Before
    public void setUp() {

        RestAssured.baseURI = "http://localhost:" + this.port;

        when(reviewRepository.findAll())
                .thenReturn(Flux.just(new Review("1", "Sergio", "content")));

    }
}

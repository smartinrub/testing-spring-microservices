package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("should return all Reviews")

    request {
        method(GET())
        url("/reviews")
    }

    response {

        status(200)
        headers {
            contentType(applicationJsonUtf8())
        }

        body("""
            [
                {"id":"1", "name":"Sergio", "text":"text"}
            ]
        """)
    }

}
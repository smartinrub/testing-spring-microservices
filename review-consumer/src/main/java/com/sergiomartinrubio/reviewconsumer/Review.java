package com.sergiomartinrubio.reviewconsumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Review {
    private String id;
    private String author;
    private String message;
}

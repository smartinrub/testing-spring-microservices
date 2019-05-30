package com.sergiomartinrubio.reviewconsumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Review {
    private final String id;
    private final String author;
    private final String text;
}

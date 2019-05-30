package com.sergiomartinrubio.reviewservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Review {
    private final String id;
    private final String name;
    private final String text;
}

package com.sergiomartinrubio.reviewservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Review {
    private String id;
    private String name;
    private String text;
}

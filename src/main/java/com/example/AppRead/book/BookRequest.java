package com.example.AppRead.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookRequest {
    private Integer id;
    private String name;
    private String pdf;
    private String cover;
    private String writer;
    private String description;
    private int num;
    private String pub;
    private String year;
}

package com.example.AppRead.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_book")
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    private String cover;
    private String writer;

    private int num;
    private String pub;

    private String year;

}

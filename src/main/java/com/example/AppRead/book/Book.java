package com.example.AppRead.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.text.DateFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String pdf;
    private String name;
    private String cover;
    private String writer;
    private String description;
    private int num;
    private String pub;
    private String year;

}

package com.school.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    private String publisher;

    @Column(name = "date_of_entry")
    private Date dateOfEntry;

    @Column(name = "number_of_page")
    private int numberOfPage;

    @OneToMany(mappedBy = "book")
    private List<Rent>rents;
}

package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enums.Genre;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private LocalDate published_year;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne(fetch = FetchType.LAZY)
    private Reader reader;
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publishers;
    @ManyToOne(fetch = FetchType.EAGER)
    private Author authors;

    public Book(String name, String country, LocalDate published_year, int price, Genre genre) {
        this.name = name;
        this.country = country;
        this.published_year = published_year;
        this.price = price;
        this.genre = genre;

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", published_year=" + published_year +
                ", price=" + price +
                ", genre=" + genre +

                '}';
    }
}

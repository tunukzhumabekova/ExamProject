package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Enums.Gender;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private LocalDate date_of_birth;
    private String country;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Publisher> publishers;
    @OneToMany(mappedBy = "authors", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Book> books;


    public Author(String first_name, String last_name, String email, LocalDate date_of_birth, String country, Gender gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.country = country;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", publishers=" + publishers +
                ", books=" + books +
                '}';
    }
}


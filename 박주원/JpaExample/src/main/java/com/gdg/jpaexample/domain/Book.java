package com.gdg.jpaexample.domain;

import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public static Book create(String title, Author author) {
        Book book = new Book(title, author);
        author.addBook(book); // 연관관계 자동 설정
        return book;
    }

    private Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public void update(String title, Author author) {
        this.title = title;
        setAuthor(author);
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

package org.jnosql.book.demo.chapter4;


import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

@Entity
public class Book {

    @Column
    private String name;

    @Column
    private Author author;

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }
}

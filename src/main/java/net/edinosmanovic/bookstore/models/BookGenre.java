package net.edinosmanovic.bookstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by eo on 6/8/17.
 */
@Entity
public enum BookGenre {
    ;


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String genreName;

    @OneToMany
    @JoinColumn(name = "genre_id")
    private Size.List<Book> books = new ArrayList<>();

    public BookGenre(){

    }

    public int getId() {
        return id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Size.List<Book> getBooks() {
        return books;
    }

    public void setBooks(Size.List<Book> books) {
        this.books = books;
    }

    FICTION ("Fiction"),
    DRAMA ("Drama"),
    ACTION ("Action"),
    MYSTERY ("Mystery"),
    HORROR ("Horror"),
    HEALTH ("Health"),
    TRAVEL ("Travel"),
    CHILDREN ("Children"),
    RELIGION ("Religion"),
    SCIENCE ("Science"),
    HISTORY ("History"),
    BIOGRAPHIES ("Biographies");


    BookGenre(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

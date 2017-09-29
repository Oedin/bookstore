package net.edinosmanovic.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by eo on 6/4/17.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=20)
    private String titleName;

    @NotNull
    @Size(min=1, message="Author Name cannot be empty!")
    private String authorName;

    @ManyToOne
    private BookGenre genre;


    public Book(String titleName, String authorName) {

        this.titleName = titleName;
        this.authorName = authorName;
    }

    public Book(){

    }


    public int getId() {
        return id;
    }

    public String getTitleName() {

        return titleName;
    }

    public void setTitleName(String titleName) {

        this.titleName = titleName;
    }

    public String getAuthorName() {

        return authorName;
    }

    public void setAuthorName(String authorName) {

        this.authorName = authorName;
    }

    public BookGenre getGenre() {

        return genre;
    }

    public void setGenre(BookGenre genre) {

        this.genre = genre;
    }
}

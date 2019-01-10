package net.bounceme.dur.jaxb.hello.world.book;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"isbn", "title","authors"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    private static final Logger LOG = Logger.getLogger(Book.class.getName());

    @XmlAttribute(name = "isbn")
    private String isbn;
    private String title;
    private List<Author> authors = new ArrayList<>();

    private Book() {
    }

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return getTitle() + getIsbn();
    }

    void add(Author author) {
        authors.add(author);
    }
}

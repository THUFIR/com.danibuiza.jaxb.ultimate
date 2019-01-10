package net.bounceme.dur.jaxb.hello.world.book;

import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

//@XmlType(propOrder = {"isbn", "title"})
//@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    private static final Logger LOG = Logger.getLogger(Book.class.getName());

    @XmlAttribute(name = "isbn")
    private String isbn;
    private String title;

    private Book() {
    }

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    private void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return getTitle() + getIsbn();
    }
}

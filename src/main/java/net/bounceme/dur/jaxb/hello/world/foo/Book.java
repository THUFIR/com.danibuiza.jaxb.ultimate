package net.bounceme.dur.jaxb.hello.world.foo;

import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"isbn", "title"})
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    private static final Logger LOG = Logger.getLogger(Book.class.getName());

    @XmlAttribute(name = "isbn")
    private String isbn;
    private String title;

    public Book() {

    }
}

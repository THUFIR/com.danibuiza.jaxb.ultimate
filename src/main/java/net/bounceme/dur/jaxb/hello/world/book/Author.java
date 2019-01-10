package net.bounceme.dur.jaxb.hello.world.book;

import java.util.Date;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"author", "name", "publisher", "isbn"})
public class Author {

    private static final Logger LOG = Logger.getLogger(Author.class.getName());

    @XmlElement(name = "author")
    private String author;

    @XmlElement(name = "first")
    private String first;

    @XmlElement(name = "last")
    private String last;

    @XmlElement(name = "born")
    private String born;

    @XmlElement(name = "died")
    private String died;

    @XmlElement(name = "date_of_birth")
    private Date dateOfBirth;

    @XmlElement(name = "date_of_death")
    private Date dateOfDeath;

    @XmlAttribute(name = "place_of_birth")
    private String placeOfBirth;

    @XmlAttribute(name = "place_of_death")
    private String placeOfDeath;
    
    

}

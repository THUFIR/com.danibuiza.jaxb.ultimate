package net.bounceme.dur.jaxb.hello.world.book;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Library {

    private static final Logger LOG = Logger.getLogger(Library.class.getName());

    private final String donor = null;
    private final List<Book> book = new ArrayList<>();

    public Library() {
    }
}

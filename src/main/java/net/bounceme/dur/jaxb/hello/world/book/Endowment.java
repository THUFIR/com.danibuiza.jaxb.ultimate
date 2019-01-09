package net.bounceme.dur.jaxb.hello.world.book;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Endowment {

    private static final Logger LOG = Logger.getLogger(Endowment.class.getName());

    private String donor = null;
    private final List<Book> book = new ArrayList<>();

    private Endowment() {
    }

    public Endowment(String donor) {
        this.donor = donor;
    }

    void add(Book b) {
        book.add(b);
    }
}
